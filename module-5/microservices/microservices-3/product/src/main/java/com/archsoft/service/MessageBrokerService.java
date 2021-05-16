package com.archsoft.service;

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

    @Value("${kafka.topic.product}")
    private String topic;

    @Value("${kafka.topic.addProductToOrder}")
    private String topicAddProductToOrder;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageBrokerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendInsertEvent(Product product) throws IOException {
        sendEvent(product, EventType.INSERT);
    }

    public void sendUpdateEvent(Product product) throws IOException {
        sendEvent(product, EventType.UPDATE);
    }

    public void sendDeleteEvent(Product product) throws IOException {
        sendEvent(product, EventType.DELETE);
    }

    private void sendEvent(Product product, EventType eventType) throws IOException {
        ProductEvent productEvent = new ProductEvent(product, eventType);
        String json = toJSON(productEvent);
        kafkaTemplate.send(topic, json);
    }
}
