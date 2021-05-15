package com.archsoft.mongodb.service;

import com.archsoft.mongodb.exception.RecordNotFoundException;
import com.archsoft.mongodb.model.Product;
import com.archsoft.mongodb.repository.ProductCacheRepository;
import com.archsoft.mongodb.repository.ProductMongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ProductDataFetcher {

    private final ProductMongoRepository productMongoRepository;
    private final ProductCacheRepository productCacheRepository;

    public ProductDataFetcher(ProductMongoRepository productMongoRepository, ProductCacheRepository productCacheRepository) {
        this.productMongoRepository = productMongoRepository;
        this.productCacheRepository = productCacheRepository;
    }

    public Product create(Product product) {
        return productMongoRepository.insert(product);
    }

    public Product find(String id) throws RecordNotFoundException {
        // Try to find the product on cache
        Product productInCache = productCacheRepository.findById(id).orElse(null);

        // If found it, return it
        if (Objects.nonNull(productInCache)) {
            return productInCache;
        }

        // If not, try to find on database
        Product productInDatabase = productMongoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));

        // save the found product into cache
        productCacheRepository.save(productInDatabase);

        return productInDatabase;
    }

    public Product update(Product product) throws RecordNotFoundException {
        productMongoRepository.findById(product.getId())
                .orElseThrow(() -> new RecordNotFoundException(product.getId()));

        // update the cached version
        productCacheRepository.save(product);

        // update the database version
        return productMongoRepository.save(product);
    }

    public void delete(String id) throws RecordNotFoundException {
        Product product = productMongoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));

        // remove the cached version
        productCacheRepository.deleteById(id);

        // remove the database version
        productMongoRepository.deleteById(id);
    }

    public List<Product> list() {
        return productMongoRepository.findAll();
    }

    public Iterable<Product> findByDescription(String description) {
        return productMongoRepository.findBaseFieldsByDescriptionLike(description);
    }
}
