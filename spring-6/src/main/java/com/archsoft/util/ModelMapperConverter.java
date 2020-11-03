package com.archsoft.util;

import com.archsoft.model.Person;
import com.archsoft.to.PersonTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelMapperConverter {

    private ModelMapper modelMapper;

    private ModelMapperConverter() {
       modelMapper = new ModelMapper();
    }

    public Person toEntity(PersonTO to) {
        return modelMapper.map(to, Person.class);
    }

    public PersonTO toTO(Person entity) {
        return modelMapper.map(entity, PersonTO.class);
    }

    public List<Person> toEntity(Iterable<PersonTO> iterable) {
        List<Person> list = new ArrayList<>();
        iterable.forEach(to -> list.add(toEntity(to)));
        return list;
    }

    public List<PersonTO> toTO(Iterable<Person> iterable) {
        List<PersonTO> list = new ArrayList<>();
        iterable.forEach(to -> list.add(toTO(to)));
        return list;
    }
}
