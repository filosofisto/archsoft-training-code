package com.archsoft.repository;

import com.archsoft.model.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    // uses regex
    @Query(value = "{ 'description': /?0/ }", fields="{ 'name': 1, 'description': 1}")
    Iterable<Product> findBaseFieldsByDescriptionLike(String description);
}
