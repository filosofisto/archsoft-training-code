package com.archsoft.service;

import com.archsoft.config.KafkaConsumerConfig;
import com.archsoft.event.AddProductToOrderEvent;
import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.product.Product;
import com.archsoft.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.archsoft.util.JSONUtil.toObject;

@Slf4j
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

        messageBrokerService.sendInsertEvent(productSaved);

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

    @KafkaListener(topics = "${kafka.topic.addProductToOrder}", groupId = KafkaConsumerConfig.GROUP)
    public void addProductToOrderListener(String message) throws IOException, RecordNotFoundException {
        log.info("AddProductToOrderEvent received: {}", message);

        AddProductToOrderEvent event = toObject(message, AddProductToOrderEvent.class);

        Product product = productRepository.findById(event.getProductId())
                .orElseThrow(() -> new RecordNotFoundException(event.getProductId()));
        int stock = Optional.ofNullable(product.getAttributes())
                .map(m -> m.get("stock"))
                .map(Integer::parseInt)
                .orElse(0);

        product.setAttribute("stock", String.valueOf(stock-event.getQuantity()));

        Product productUpdated = productRepository.save(product);
        messageBrokerService.sendUpdateEvent(productUpdated);
    }
}
