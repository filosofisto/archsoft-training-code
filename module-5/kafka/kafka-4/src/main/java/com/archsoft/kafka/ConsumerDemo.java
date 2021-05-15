package com.archsoft.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Optional;
import java.util.Properties;

public class ConsumerDemo {

    private static final Logger log = LoggerFactory.getLogger(ConsumerDemo.class);

    private static final String TOPIC = "first_topic";
    private static final String GROUP_ID = "Group-Kafka-4";

    public static void main(String[] args) {
        // Create properties
        Properties properties = new Properties();

        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        // Create Consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // Subscripe into topics
        consumer.subscribe(Collections.singleton(TOPIC));

        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(100));

            consumerRecords.forEach(record -> log.info("Key: {}, Value: {}, Partition: {}, Offset: {}",
                    record.key(), record.value(), record.partition(), record.offset()));
        }
    }
}
