package com.archsoft.controller;

import com.archsoft.aspect.Hateoas;
import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.Person;
import com.archsoft.service.PersonService;
import com.archsoft.to.PersonTO;
import com.archsoft.util.converter.DirectionConverter;
import com.archsoft.util.converter.PersonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    private final PersonConverter personConverter;

    private final PagedResourcesAssembler<PersonTO> assembler;

    @Autowired
    public PersonController(PersonService personService,
                            PersonConverter personConverter,
                            PagedResourcesAssembler<PersonTO> assembler) {
        this.personService = personService;
        this.personConverter = personConverter;
        this.assembler = assembler;
    }

    @PostMapping
    @Hateoas
    public ResponseEntity<PersonTO> create(@RequestBody PersonTO personTO) throws RecordNotFoundException {
        Person person = personService.create(personConverter.toEntity(personTO));

        return ResponseEntity.ok(personConverter.toTransferObject(person));
    }

    @GetMapping("/{id}")
    @Hateoas
    public ResponseEntity<PersonTO> read(@PathVariable("id") Long id) throws RecordNotFoundException {
        return ResponseEntity.ok(personConverter.toTransferObject(personService.read(id)));
    }

    @PutMapping
    @Hateoas
    public ResponseEntity<PersonTO> update(@RequestBody PersonTO personTO) throws RecordNotFoundException {
        Person person = personService.update(personConverter.toEntity(personTO));

        return ResponseEntity.ok(personConverter.toTransferObject(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws RecordNotFoundException {
        personService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Hateoas
    public ResponseEntity<PagedModel<EntityModel<PersonTO>>> list(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction,
            @RequestParam(value = "sortBy", defaultValue = "name") String sortBy) throws RecordNotFoundException {
        Pageable pageable = PageRequest.of(page, size, DirectionConverter.from(direction), sortBy);
        Page<PersonTO> pageResult = personConverter.toTransferObject(personService.findAll(pageable));
        PagedModel<EntityModel<PersonTO>> pagedModel = assembler.toModel(pageResult);

        return ResponseEntity.ok(pagedModel);
    }
}
