package com.archsoft.service.impl;

import com.archsoft.exception.OperationException;
import com.archsoft.mode.Account;
import com.archsoft.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class ThreadSafeAccountService implements AccountService {

    public BigDecimal withdraw(Account account, BigDecimal value) throws OperationException {
        try {
            boolean locked = account.getLock().tryLock(2, TimeUnit.SECONDS);

            if (!locked) {
                log.error("Operation failed, can not lock account, try later");
                throw new OperationException("Operation failed, can not lock account, try later");
            }

            if (account.getLock().isHeldByCurrentThread()) {
                log.warn("Account {} is LOCKED", account.getNumber());
                executeWithdrawOperation(account, value);
            }
        } catch (InterruptedException e) {
            throw new OperationException(e);
        } finally {
            account.getLock().unlock();
            log.warn("Account {} is UNLOCKED", account.getNumber());
        }

        return account.getBalance();
    }

    @Override
    public void transfer(Account accountSource, Account accountTarget, BigDecimal value)
            throws OperationException {
        lockAccountSource(accountSource);
        lockAccountTarget(accountSource, accountTarget);

        tryWithdraw(accountSource, accountTarget, value);
        tryDeposit(accountSource, accountTarget, value);
    }

    private void tryDeposit(Account accountSource, Account accountTarget, BigDecimal value) throws OperationException {
        try {
            executeDepositOperation(accountTarget, value);
        } catch (OperationException e) {
            // rollback in source account
            executeDepositOperation(accountSource, value);

            log.error("Error on withdraw operation into source account");
            throw new OperationException("Error on withdraw operation into source account");
        } finally {
            accountSource.getLock().unlock();
            accountTarget.getLock().unlock();
        }
    }

    private void tryWithdraw(Account accountSource, Account accountTarget, BigDecimal value) throws OperationException {
        try {
            executeWithdrawOperation(accountSource, value);
        } catch (OperationException e) {
            accountSource.getLock().unlock();
            accountTarget.getLock().unlock();
            log.error("Error on withdraw operation into source account");
            throw new OperationException("Error on withdraw operation into source account");
        }
    }

    /**
     * Try lock target account.
     *
     * @param accountSource
     * @param accountTarget
     * @throws OperationException
     */
    private void lockAccountTarget(Account accountSource, Account accountTarget) throws OperationException {
        boolean lockTarget;

        try {
            lockTarget = accountTarget.getLock().tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("It was not possible lock account {}", accountTarget.getNumber());

            // unlock source account
            accountSource.getLock().unlock();
            log.warn("Account {} is UNLOCKED", accountSource.getNumber());

            log.error(e.getMessage(), e);
            throw new OperationException(e);
        }

        if (!lockTarget || !accountTarget.getLock().isHeldByCurrentThread()) {
            // unlock source account
            accountSource.getLock().unlock();
            log.error("Not possible lock target account");
            throw new OperationException("Not possible lock target account");
        }

        log.warn("Account {} is LOCKED", accountTarget.getNumber());
    }

    /**
     * Try lock source account.
     *
     * @param accountSource
     * @throws OperationException
     */
    private void lockAccountSource(Account accountSource) throws OperationException {
        boolean lockSource;

        try {
            lockSource = accountSource.getLock().tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("It was not possible lock account {}", accountSource.getNumber());
            log.error(e.getMessage(), e);
            throw new OperationException(e);
        }

        if (!lockSource || !accountSource.getLock().isHeldByCurrentThread()) {
            log.error("It was not possible lock account {}", accountSource.getNumber());
            throw new OperationException("Not possible lock source account");
        }

        log.warn("Account {} is LOCKED", accountSource.getNumber());
    }

    private BigDecimal executeWithdrawOperation(Account account, BigDecimal value) throws OperationException {
        if (account.getBalance().compareTo(value) < 0) {
            log.info("Insufficient Balance for account: {}, balance: {}, operation value: {}",
                    account.getNumber(), account.getBalance().doubleValue(), value.doubleValue());
            throw new OperationException("Insufficient balance");
        }

        BigDecimal oldBalance = account.getBalance();
        account.setBalance(account.getBalance().subtract(value));
        log.info("Operation performed successfully for account: {}, balance: {}, operation value: {}, new balance: {}",
                account.getNumber(), oldBalance.doubleValue(), value.doubleValue(), account.getBalance().doubleValue());

        return account.getBalance();
    }

    private BigDecimal executeDepositOperation(Account account, BigDecimal value)
            throws OperationException {
        BigDecimal oldBalance = account.getBalance();
        account.setBalance(account.getBalance().add(value));
        log.info("Operation performed successfully for account: {}, balance: {}, operation value: {}, new balance: {}",
                account.getNumber(), oldBalance.doubleValue(), value.doubleValue(), account.getBalance().doubleValue());

        // others operations could cause exception ...

        return account.getBalance();
    }
}
