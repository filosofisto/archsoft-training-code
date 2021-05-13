package com.archsoft.service;

import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.Product;
import com.archsoft.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Product checkAvailability(String productId, Integer quantity)
            throws RecordNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RecordNotFoundException(productId));

        int stock = Optional.ofNullable(product.getAttributes())
                .map(m -> m.get("stock"))
                .map(Integer::parseInt)
                .orElse(0);

        if (stock >= quantity) {
            product.setAttribute("stock", String.valueOf(stock - quantity));
            return productRepository.save(product);
        }

        return null;
    }
}
