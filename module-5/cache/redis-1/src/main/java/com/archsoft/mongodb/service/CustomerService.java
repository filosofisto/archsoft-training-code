package com.archsoft.mongodb.service;

import com.archsoft.mongodb.exception.RecordNotFoundException;
import com.archsoft.mongodb.model.Customer;
import com.archsoft.mongodb.repository.CustomerCacheRepository;
import com.archsoft.mongodb.repository.CustomerMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private final CustomerMongoRepository customerMongoRepository;
    private final CustomerCacheRepository customerCacheRepository;

    public CustomerService(CustomerMongoRepository customerMongoRepository, CustomerCacheRepository customerCacheRepository) {
        this.customerMongoRepository = customerMongoRepository;
        this.customerCacheRepository = customerCacheRepository;
    }

    public Customer create(Customer customer) {
        return customerMongoRepository.insert(customer);
    }

    public Customer find(String id) throws RecordNotFoundException {
        // Try to find the Customer on cache
        Customer customerInCache = customerCacheRepository.findById(id).orElse(null);

        // If found it, return it
        if (Objects.nonNull(customerInCache)) {
            return customerInCache;
        }

        // If not, try to find on database
        Customer customerInDatabase = customerMongoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));

        // save the found Customer into cache
        customerCacheRepository.save(customerInDatabase);

        return customerInDatabase;
    }

    public Customer findByEmail(String email) throws RecordNotFoundException {
        // Try to find the Customer on cache
        Customer customerInCache = customerCacheRepository.findByEmail(email).orElse(null);

        // If found it, return it
        if (Objects.nonNull(customerInCache)) {
            return customerInCache;
        }

        // If not, try to find on database
        Customer customerInDatabase = customerMongoRepository.findByEmail(email)
                .orElseThrow(() -> new RecordNotFoundException(email));

        // save the found Customer into cache
        customerCacheRepository.save(customerInDatabase);

        return customerInDatabase;
    }

    public Customer update(Customer customer) throws RecordNotFoundException {
        customerMongoRepository.findById(customer.getId())
                .orElseThrow(() -> new RecordNotFoundException(customer.getId()));

        // update the cached version
        customerCacheRepository.save(customer);

        // update the database version
        return customerMongoRepository.save(customer);
    }

    public void delete(String id) throws RecordNotFoundException {
        Customer customer = customerMongoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));

        // remove the cached version
        customerCacheRepository.deleteById(id);
        customerCacheRepository.deleteByEmail(customer.getEmail());

        // remove the database version
        customerMongoRepository.deleteById(id);
    }

    public List<Customer> list() {
        return customerMongoRepository.findAll();
    }

}
