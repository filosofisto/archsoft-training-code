package com.archsoft.service;

import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.Product;
import com.archsoft.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final MessageBrokerService messageBrokerService;

    public ProductService(ProductRepository productRepository, MessageBrokerService messageBrokerService) {
        this.productRepository = productRepository;
        this.messageBrokerService = messageBrokerService;
    }

    public Product create(Product product) throws IOException {
        Product productSaved = productRepository.insert(product);

        messageBrokerService.sendInsertEvent(product);

        return productSaved;
    }

    public Product find(String id) throws RecordNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Product update(Product product) throws RecordNotFoundException, IOException {
        productRepository.findById(product.getId())
                .orElseThrow(() -> new RecordNotFoundException(product.getId()));

        Product productUpdated = productRepository.save(product);
        messageBrokerService.sendUpdateEvent(productUpdated);

        return productUpdated;
    }

    public void delete(String id) throws RecordNotFoundException, IOException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
        productRepository.delete(product);

        messageBrokerService.sendDeleteEvent(product);
    }

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Iterable<Product> findByDescription(String description) {
        return productRepository.findBaseFieldsByDescriptionLike(description);
    }

    public Product checkAvailability(String productId, Integer quantity)
            throws RecordNotFoundException, IOException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RecordNotFoundException(productId));

        int stock = Optional.ofNullable(product.getAttributes())
                .map(m -> m.get("stock"))
                .map(Integer::parseInt)
                .orElse(0);

        if (stock >= quantity) {
            product.setAttribute("stock", String.valueOf(stock - quantity));
            Product productUpdated = productRepository.save(product);
            messageBrokerService.sendUpdateEvent(productUpdated);

            return productUpdated;
        }

        return null;
    }

    public void addStock(String productId, Integer quantity) throws RecordNotFoundException, IOException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RecordNotFoundException(productId));

        int stock = Optional.ofNullable(product.getAttributes())
                .map(m -> m.get("stock"))
                .map(Integer::parseInt)
                .orElse(0);

        product.setAttribute("stock", String.valueOf(stock + quantity));

        Product productUpdated = productRepository.save(product);
        messageBrokerService.sendUpdateEvent(productUpdated);
    }
}
