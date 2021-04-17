package com.archsoft.service.impl;

import com.archsoft.model.Person;
import com.archsoft.service.ApplicatioService;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class DefaultApplicationService implements ApplicatioService {

    @Override
    public Person processAnyValidPerson() {
        PersistenceService persistenceService = new PersistenceService();
        PersonService personService = new PersonService();

        List<Person> people = persistenceService.loadPeople();

        for (Person person: people) {
            personService.process(person);
        }

        Random random = new Random();
        int pos = random.nextInt(people.size());

        return people.get(pos);
    }
}
