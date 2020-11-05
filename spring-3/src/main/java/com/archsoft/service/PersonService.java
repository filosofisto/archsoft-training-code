package com.archsoft.service;

import com.archsoft.model.Person;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PersonService {

    public List<Person> getAllPeople() {
        List<Person> list = new LinkedList<>();

        list.add(new Person(1L, "Eduardo Ribeiro", 49));
        list.add(new Person(2L, "Saint Yves d'Alveydre", 35));
        list.add(new Person(3L, "Francisco de Assis", 67));
        list.add(new Person(4L, "Joao Paulo II", 88));
        list.add(new Person(5L, "Martin Luter King", 55));
        list.add(new Person(6L, "Jesus Cristo", 33));
        list.add(new Person(7L, "Sidarta Gautama", 80));

        return list;
    }
}
