package com.archsoft.mongodb.repository;

import com.archsoft.mongodb.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

//    Customer findOne(Long id);

    Optional<Customer> findByEmail(String email);

//    Customer save(Customer customer);
}
