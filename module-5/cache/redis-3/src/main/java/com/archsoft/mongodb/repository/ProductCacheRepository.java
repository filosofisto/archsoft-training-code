package com.archsoft.mongodb.repository;

import com.archsoft.mongodb.model.Product;

import java.util.Optional;

public interface ProductCacheRepository {

    Optional<Product> findById(String id);

    void save(Product product);

    void deleteById(String id);
}
