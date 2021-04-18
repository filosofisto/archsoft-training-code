package com.archsoft;

import com.archsoft.exception.OperationException;
import com.archsoft.mode.Account;
import com.archsoft.service.AccountService;
import com.archsoft.service.impl.DefaultAccountService;
import com.archsoft.service.impl.ThreadSafeAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class CommandTask implements CommandLineRunner {

    @Override
    public void run(String... args) {
        withdrawScenarios();

    }

    private void withdrawScenarios() {
        Account account = new Account("1456", new BigDecimal("25000"));

//        AccountService accountService = new DefaultAccountService();
        AccountService accountService = new ThreadSafeAccountService();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        CompletableFuture.allOf(
                asyncWithdraw(account, accountService, 24000d),
                asyncWithdraw(account, accountService, 500d),
                asyncWithdraw(account, accountService, 300d),
                asyncWithdraw(account, accountService, 200d),
                asyncWithdraw(account, accountService, 100d),
                asyncWithdraw(account, accountService, 110d),
                asyncWithdraw(account, accountService, 120d),
                asyncWithdraw(account, accountService, 130d),
                asyncWithdraw(account, accountService, 140d),
                asyncWithdraw(account, accountService, 150d))
                .thenRun(() -> log.info(
                        "Final balance after withdraw operations: {}",
                        account.getBalance().doubleValue()));
    }

    private void transferScenarios() {
        Account accountSource = new Account("9285", new BigDecimal("17000"));
        Account accountTarget = new Account("1456", new BigDecimal("0"));

//        AccountService accountService = new DefaultAccountService();
        AccountService accountService = new ThreadSafeAccountService();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        CompletableFuture.allOf(
                asyncTransfer(accountSource, accountTarget, accountService, 7000d),
                asyncTransfer(accountSource, accountTarget, accountService, 500d),
                asyncTransfer(accountSource, accountTarget, accountService, 300d),
                asyncTransfer(accountSource, accountTarget, accountService, 200d),
                asyncTransfer(accountSource, accountTarget, accountService, 10000d),
                asyncTransfer(accountSource, accountTarget, accountService, 1d),
                asyncTransfer(accountSource, accountTarget, accountService, 1d),
                asyncTransfer(accountSource, accountTarget, accountService, 1d),
                asyncTransfer(accountSource, accountTarget, accountService, 1d),
                asyncTransfer(accountSource, accountTarget, accountService, 1d))
                .thenRun(() -> log.info(
                        "Final balance after transfer operations: {}",
                        accountSource.getBalance().doubleValue()));
    }

    private CompletableFuture<Void> asyncWithdraw(Account account, AccountService accountService, double value) {
        return CompletableFuture
                .runAsync(() -> {
                    try {
                        accountService.withdraw(account, new BigDecimal(value));
                    } catch (OperationException e) {
                        throw new RuntimeException(e);
                    }
                })
                .exceptionally(e -> {
                    log.error(e.getMessage());
                    return null;
                });
    }

    private CompletableFuture<Void> asyncTransfer(
            Account accountSource,
            Account accountTarget,
            AccountService accountService,
            double value) {
        return CompletableFuture
                .runAsync(() -> {
                    try {
                        accountService.transfer(accountSource, accountTarget, new BigDecimal(value));
                    } catch (OperationException e) {
                        throw new RuntimeException(e);
                    }
                })
                .exceptionally(e -> {
                    log.error(e.getMessage());
                    return null;
                });
    }
}
