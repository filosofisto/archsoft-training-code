package com.archsoft.service;

import com.archsoft.event.EventType;
import com.archsoft.event.PaymentEvent;
import com.archsoft.model.payment.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.archsoft.util.JSONUtil.toJSON;

@Service
public class MessageBrokerService {

    @Value("${kafka.topic.payment}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageBrokerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendInsertEvent(Payment payment) throws IOException {
        sendEvent(payment, EventType.INSERT);
    }

    public void sendUpdateEvent(Payment payment) throws IOException {
        sendEvent(payment, EventType.UPDATE);
    }

    public void sendDeleteEvent(Payment payment) throws IOException {
        sendEvent(payment, EventType.DELETE);
    }

    private void sendEvent(Payment payment, EventType eventType) throws IOException {
        PaymentEvent paymentEvent = new PaymentEvent(payment, eventType);
        String json = toJSON(paymentEvent);
        kafkaTemplate.send(topic, json);
    }
}
