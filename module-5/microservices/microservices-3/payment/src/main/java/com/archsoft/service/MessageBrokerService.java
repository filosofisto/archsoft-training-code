package com.archsoft.service;

import org.springframework.stereotype.Service;

@Service
public class MessageBrokerService {

    /*@Value("${kafka.topic.product}")
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
    }*/
}
