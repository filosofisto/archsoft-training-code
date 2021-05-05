package com.archsoft.mongodb.repository.impl;

import com.archsoft.mongodb.model.Product;
import com.archsoft.mongodb.repository.ProductCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductCacheRepositoryRedis implements ProductCacheRepository {

    private static final String KEY = "PRODUCT";

    private final RedisTemplate<String, Object> redisTemplate;

    public ProductCacheRepositoryRedis(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(KEY + id))
                .map(object -> (Product) object);
    }

    @Override
    public void save(Product product) {
        redisTemplate.opsForValue().set(KEY + product.getId(), product);
    }

    @Override
    public void deleteById(String id) {
        redisTemplate.opsForHash().delete(KEY, id);
    }
}
