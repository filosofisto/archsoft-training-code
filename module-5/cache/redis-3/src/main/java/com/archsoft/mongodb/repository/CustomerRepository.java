package com.archsoft.mongodb.repository;

import com.archsoft.mongodb.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, BigInteger> {

//    Customer findOne(Long id);

//    Customer findByEmail(String email);

//    Customer save(Customer customer);
}
