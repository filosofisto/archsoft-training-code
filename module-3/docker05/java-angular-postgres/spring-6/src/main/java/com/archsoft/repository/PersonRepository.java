package com.archsoft.repository;

import com.archsoft.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p from Person p order by p.name")
    @Override
    Iterable<Person> findAll();
}
