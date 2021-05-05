package com.archsoft.mongodb.repository.impl;

import com.archsoft.mongodb.model.Customer;
import com.archsoft.mongodb.model.Product;
import com.archsoft.mongodb.repository.CustomerCacheRepository;
import com.archsoft.mongodb.repository.ProductCacheRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerCacheRepositoryRedis implements CustomerCacheRepository {

    private static final String KEY = "CUSTOMER";

    private final RedisTemplate<String, Object> redisTemplate;

    public CustomerCacheRepositoryRedis(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Optional<Customer> findById(String id) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(KEY + id))
                .map(object -> (Customer) object);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(KEY + email))
                .map(object -> (Customer) object);
    }

    @Override
    public void save(Customer customer) {
        redisTemplate.opsForValue().set(KEY + customer.getId(), customer);
        redisTemplate.opsForValue().set(KEY + customer.getEmail(), customer);
    }

    @Override
    public void deleteById(String id) {
        redisTemplate.opsForHash().delete(KEY, id);
    }

    @Override
    public void deleteByEmail(String email) {
        redisTemplate.opsForHash().delete(KEY, email);
    }
}
