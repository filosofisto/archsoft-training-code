package com.archsoft.mongodb.repository;

import com.archsoft.mongodb.model.Customer;

import java.util.Optional;

public interface CustomerCacheRepository {

    Optional<Customer> findById(String id);

    Optional<Customer> findByEmail(String email);

    void save(Customer customer);

    void deleteById(String id);

    void deleteByEmail(String email);
}
