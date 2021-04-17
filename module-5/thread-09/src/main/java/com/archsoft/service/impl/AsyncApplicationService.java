package com.archsoft.service.impl;

import com.archsoft.model.Log;
import com.archsoft.model.Person;
import com.archsoft.service.ApplicatioService;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncApplicationService implements ApplicatioService {

    @Override
    public Person processAnyValidPerson() {
        // Services
        PersistenceService persistenceService = new PersistenceService();
        PersonService personService = new PersonService();
        LogService logService = new LogService();

        List<Person> people = persistenceService.loadPeople();

        // Execute asynchronously the validation for each person
        List<CompletableFuture<Person>> completableFutures = new LinkedList<>();
        ExecutorService pool = Executors.newWorkStealingPool();

        for (Person person: people) {
            completableFutures.add(CompletableFuture.supplyAsync(() -> personService.process(person)));
        }

        try {
            return (Person) CompletableFuture.anyOf(completableFutures.toArray(new CompletableFuture[0]))
                    .exceptionally(e -> {
                        logService.sendLog(new Log(e));
                        return null;
                    }).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
