package com.archsoft.service.impl;

import com.archsoft.exception.InvalidDataException;
import com.archsoft.model.Client;
import com.archsoft.model.Log;
import com.archsoft.service.ApplicatioService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncApplicationService implements ApplicatioService {

    @Override
    public void saveClient(Client client) throws InvalidDataException {
        // Services
        ValidatorService validatorService = new ValidatorService();
        LogService logService = new LogService();
        PersistenceService persistenceService = new PersistenceService();

        // Execute asynchronously the services
        ExecutorService pool = Executors.newWorkStealingPool();

        CompletableFuture<Void> cfAddress = checkAddress(client, validatorService, pool);
        CompletableFuture<Void> cfPhone = checkPhone(client, validatorService, pool);
        CompletableFuture<Void> cfDocument = checkDocument(client, validatorService, pool);

        CompletableFuture.allOf(cfAddress, cfPhone, cfDocument).thenRunAsync(() -> {
            persistenceService.save(client);
        }).exceptionally((e) -> {
            logService.sendLog(Log.builder().exception(e).build());
            return null;
        }).join();
    }

    private CompletableFuture<Void> checkDocument(Client client,
                                                  ValidatorService validatorService,
                                                  ExecutorService pool) {
        return CompletableFuture.runAsync(() ->
        {
            try {
                validatorService.validateDocument(client);
            } catch (InvalidDataException e) {
                throw new RuntimeException(e);
            }
        }, pool);
    }

    private CompletableFuture<Void> checkPhone(Client client,
                                               ValidatorService validatorService,
                                               ExecutorService pool) {
        return CompletableFuture.runAsync(() ->
        {
            try {
                validatorService.validatePhone(client);
            } catch (InvalidDataException e) {
                throw new RuntimeException(e);
            }
        }, pool);
    }

    private CompletableFuture<Void> checkAddress(Client client,
                                                 ValidatorService validatorService,
                                                 ExecutorService pool) {
        return CompletableFuture.runAsync(() ->
        {
            try {
                validatorService.validateAddress(client);
            } catch (InvalidDataException e) {
                throw new RuntimeException(e);
            }
        }, pool);
    }
}
