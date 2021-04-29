package com.archsoft.mongodb.repository;

import com.archsoft.mongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMongoRepository extends MongoRepository<Product, String> {

    // uses regex
    @Query(value = "{ 'description': /?0/ }", fields="{ 'name': 1, 'description': 1}")
    Iterable<Product> findBaseFieldsByDescriptionLike(String description);
}
