package com.archsoft.controller;

import com.archsoft.model.Person;
import com.archsoft.service.PersonService;
import com.archsoft.to.PersonTO;
import com.archsoft.util.converter.DirectionConverter;
import com.archsoft.util.converter.PersonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<PersonTO>> list(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction,
            @RequestParam(value = "sortBy", defaultValue = "name") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, DirectionConverter.from(direction), sortBy);
        return ResponseEntity.ok(personConverter.toTransferObject(personService.findAll(pageable)));
    }
}
