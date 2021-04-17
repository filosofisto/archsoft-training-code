package com.archsoft.service.impl;

import com.archsoft.model.Person;
import com.archsoft.util.Util;

import static java.lang.System.out;

public class PersonService {

    public Person process(Person person) {
        // consume some service to validate address
        out.printf("Person %s in processing...\n", person.getName());
        Util.waitFor(1);
        out.printf("Person %s processed\n", person.getName());

        return person;
    }
}
