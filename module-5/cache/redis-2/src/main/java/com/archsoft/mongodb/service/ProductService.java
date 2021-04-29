package com.archsoft.mongodb.service;

import com.archsoft.mongodb.exception.RecordNotFoundException;
import com.archsoft.mongodb.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDataFetcher productDataFetcher;

    public ProductService(ProductDataFetcher productDataFetcher) {
        this.productDataFetcher = productDataFetcher;
    }

    public Product create(Product product) {
        return productDataFetcher.create(product);
    }

    public Product find(String id) throws RecordNotFoundException {
        return productDataFetcher.find(id);
    }

    public Product update(Product product) throws RecordNotFoundException {
        return productDataFetcher.update(product);
    }

    public void delete(String id) throws RecordNotFoundException {
        productDataFetcher.delete(id);
    }

    public List<Product> list() {
        return productDataFetcher.list();
    }

    public Iterable<Product> findByDescription(String description) {
        return productDataFetcher.findByDescription(description);
    }
}
