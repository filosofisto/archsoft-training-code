package com.archsoft.mongodb.repository;

import com.archsoft.mongodb.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerMongoRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByEmail(String email);
}
