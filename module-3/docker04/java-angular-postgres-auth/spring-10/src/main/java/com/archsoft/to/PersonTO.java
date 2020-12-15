package com.archsoft.to;

import com.archsoft.aspect.ApplyHateoas;
import com.archsoft.controller.PersonController;
import com.archsoft.exception.RecordNotFoundException;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.io.Serializable;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PersonTO
        extends RepresentationModel<PersonTO>
        implements ApplyHateoas<PersonTO>, Serializable {

    private static final long serialVersionUID = 2676165740000781111L;

    private Long id;
    private String name;
    private Integer age;

    public PersonTO apply() throws RecordNotFoundException {
        add(linkTo(methodOn(PersonController.class).read(id)).withSelfRel());

        return this;
    }
}
