package com.archsoft.service;

import com.archsoft.event.AddProductToOrderEvent;
import com.archsoft.event.EventType;
import com.archsoft.event.ProductEvent;
import com.archsoft.model.product.Product;
import com.archsoft.util.JSONUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.archsoft.util.JSONUtil.toJSON;

@Service
public class MessageBrokerService {

    @Value("${kafka.order.addProduct}")
    private String topicAddProduct;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageBrokerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendAddProduct(String productId, Integer quantity) throws IOException {
        AddProductToOrderEvent event = new AddProductToOrderEvent(EventType.UPDATE, productId, quantity);
        String json = toJSON(event);
        kafkaTemplate.send(topicAddProduct, json);
    }
}
