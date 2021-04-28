package com.archsoft.mongodb.repository;

import com.archsoft.mongodb.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CustomerRepository extends CrudRepository<Product, BigInteger> {

//    Customer findOne(Long id);

//    Customer findByEmail(String email);

//    Customer save(Customer customer);
}
