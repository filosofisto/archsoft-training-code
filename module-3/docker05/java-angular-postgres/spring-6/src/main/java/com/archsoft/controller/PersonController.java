package com.archsoft.controller;

import com.archsoft.model.Person;
import com.archsoft.service.PersonService;
import com.archsoft.to.PersonTO;
import com.archsoft.util.converter.PersonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    private final PersonConverter personConverter;

    @Autowired
    public PersonController(PersonService personService, PersonConverter personConverter) {
        this.personService = personService;
        this.personConverter = personConverter;
    }

    @PostMapping
    public ResponseEntity<PersonTO> create(@RequestBody PersonTO personTO) {
        Person person = personService.create(personConverter.toEntity(personTO));

        return ResponseEntity.ok(personConverter.toTransferObject(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonTO> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personConverter.toTransferObject(personService.read(id)));
    }

    @PutMapping
    public ResponseEntity<PersonTO> update(@RequestBody PersonTO personTO) {
        Person person = personService.update(personConverter.toEntity(personTO));

        return ResponseEntity.ok(personConverter.toTransferObject(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        personService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonTO>> list() {
        return ResponseEntity.ok(personConverter.toTransferObject(personService.findAll()));
    }
}
