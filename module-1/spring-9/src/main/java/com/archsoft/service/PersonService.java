package com.archsoft.service;

import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.Person;
import com.archsoft.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person read(Long id) throws RecordNotFoundException {
        return findByIdOrThrowException(id);
    }

    public Person update(Person person) throws RecordNotFoundException {
        findByIdOrThrowException(person.getId());

        return personRepository.save(person);
    }

    public void delete(Long id) throws RecordNotFoundException {
        Person person = findByIdOrThrowException(id);

        personRepository.delete(person);
    }

    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    private Person findByIdOrThrowException(Long id) throws RecordNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Registro nao encontrado com o id " + id));
    }
}
