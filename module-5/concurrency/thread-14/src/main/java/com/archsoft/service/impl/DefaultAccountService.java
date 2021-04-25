package com.archsoft.service.impl;

import com.archsoft.exception.OperationException;
import com.archsoft.mode.Account;
import com.archsoft.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class DefaultAccountService implements AccountService {

    @Override
    public void transfer(Account accountSource, Account accountTarget, BigDecimal value)
            throws OperationException {
        if (accountSource.getBalance().compareTo(value) < 0) {
            log.info("Insufficient Balance for account: {}, balance: {}, operation value: {}",
                    accountSource.getNumber(), accountSource.getBalance().doubleValue(), value.doubleValue());
            throw new OperationException("Insufficient balance");
        }

        BigDecimal oldBalance = accountSource.getBalance();
        accountSource.setBalance(accountSource.getBalance().subtract(value));
        log.info("Operation performed successfully for account: {}, balance: {}, operation value: {}, new balance: {}",
                accountSource.getNumber(), oldBalance.doubleValue(), value.doubleValue(), accountSource.getBalance().doubleValue());

        oldBalance = accountTarget.getBalance();
        accountTarget.setBalance(accountTarget.getBalance().add(value));
        log.info("Operation performed successfully for account: {}, balance: {}, operation value: {}, new balance: {}",
                accountTarget.getNumber(), oldBalance.doubleValue(), value.doubleValue(), accountTarget.getBalance().doubleValue());
    }

    @Override
    public BigDecimal withdraw(Account account, BigDecimal value) throws OperationException {
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
}
