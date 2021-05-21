package com.archsoft.service;

import com.archsoft.config.KafkaConsumerConfig;
import com.archsoft.event.ProductEvent;
import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.product.Product;
import com.archsoft.repository.ProductRepository;
import com.archsoft.util.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.archsoft.util.JSONUtil.toObject;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @KafkaListener(topics = "${kafka.product.topic}", groupId = KafkaConsumerConfig.GROUP)
    public void productListener(String message) throws JsonProcessingException {
        log.info("ProductListener received message: {}", message);

        ProductEvent productEvent = toObject(message, ProductEvent.class);
        Product product = productEvent.getProduct();

        switch (productEvent.getEventType()) {
            case INSERT:
                processInsert(product);
                break;
            case UPDATE:
                processUpdate(product);
                break;
            case DELETE:
                processDelete(product);
        }
    }

    private void processInsert(Product product) {
        product.setOriginalId(product.getId());
        product.setId(null);

        productRepository.save(product);
    }

    private void processUpdate(Product product) {
        Optional<Product> optionalProduct = productRepository.findByOriginalId(product.getId());

        if (optionalProduct.isPresent()) {
            Product productSaved = optionalProduct.get();

            productSaved.setName(product.getName());
            productSaved.setDescription(product.getDescription());
            productSaved.setCategory(product.getCategory());
            productSaved.setPrice(product.getPrice());
            productSaved.setAttributes(product.getAttributes());

            productRepository.save(productSaved);
        } else {
            processInsert(product);
        }
    }

    private void processDelete(Product product) {
        productRepository.findByOriginalId(product.getId())
                .ifPresent(productSaved -> productRepository.delete(productSaved));
    }

    public Product readByOriginalId(String productId) throws RecordNotFoundException {
        return productRepository.findByOriginalId(productId)
                .orElseThrow(() -> new RecordNotFoundException(productId));
    }

    public Product read(String productId) throws RecordNotFoundException {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RecordNotFoundException(productId));
    }
}
