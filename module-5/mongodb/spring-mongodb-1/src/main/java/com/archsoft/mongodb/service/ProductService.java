package com.archsoft.mongodb.service;

import com.archsoft.mongodb.exception.RecordNotFoundException;
import com.archsoft.mongodb.model.Product;
import com.archsoft.mongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.insert(product);
    }

    public Product find(String id) throws RecordNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Product update(Product product) throws RecordNotFoundException {
        productRepository.findById(product.getId())
                .orElseThrow(() -> new RecordNotFoundException(product.getId()));

        return productRepository.save(product);
    }

    public void delete(String id) throws RecordNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
        productRepository.delete(product);
    }

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Iterable<Product> findByDescription(String description) {
        return productRepository.findBaseFieldsByDescriptionLike(description);
    }
}
