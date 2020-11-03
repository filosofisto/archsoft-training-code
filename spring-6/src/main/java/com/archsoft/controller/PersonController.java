package com.archsoft.controller;

import com.archsoft.model.Person;
import com.archsoft.service.PersonService;
import com.archsoft.to.PersonTO;
import com.archsoft.util.ModelMapperConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    private final ModelMapperConverter modelMapperConverter;

    @Autowired
    public PersonController(PersonService personService, ModelMapperConverter modelMapperConverter) {
        this.personService = personService;
        this.modelMapperConverter = modelMapperConverter;
    }

    @PostMapping
    public ResponseEntity<PersonTO> create(@RequestBody PersonTO personTO) {
        Person person = personService.create(modelMapperConverter.toEntity(personTO));

        return ResponseEntity.ok(modelMapperConverter.toTO(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonTO> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(modelMapperConverter.toTO(personService.read(id)));
    }

    @PutMapping
    public ResponseEntity<PersonTO> update(@RequestBody PersonTO personTO) {
        Person person = personService.update(modelMapperConverter.toEntity(personTO));

        return ResponseEntity.ok(modelMapperConverter.toTO(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        personService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PersonTO>> list() {
        return ResponseEntity.ok(modelMapperConverter.toTO(personService.findAll()));
    }
}
