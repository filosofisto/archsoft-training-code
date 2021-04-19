package com.archsoft.service.impl;

import com.archsoft.model.Person;
import com.archsoft.util.Util;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class PersistenceService {

    public List<Person> loadPeople() {
        out.println("Loading people...");
        Util.waitFor(2);

        List<Person> set = new ArrayList<>();
        set.add(Person.builder().name("Eduardo").build());
        set.add(Person.builder().name("Pedro").build());
        set.add(Person.builder().name("Joao").build());
        set.add(Person.builder().name("Maria").build());
        set.add(Person.builder().name("Francisco").build());
        set.add(Person.builder().name("Helena").build());
        set.add(Person.builder().name("Socrates").build());
        set.add(Person.builder().name("Platao").build());

        out.println("People loaded from database");

        return set;
    }
}
