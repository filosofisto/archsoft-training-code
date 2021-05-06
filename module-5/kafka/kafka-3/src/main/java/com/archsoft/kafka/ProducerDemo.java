package com.archsoft.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Properties;

public class ProducerDemo {

    private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class);

    private static final String TOPIC = "first_topic";

    public static void main(String[] args) {
        // Create properties
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create Producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        for (int i = 1; i < 11; i++) {
            String key = "id_" + i;
            String value = "Hello World " + i;

            log.info("Key: {}", key);

            // Create ProducerRecord
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, key, value);

            // Send data asynchronous
            producer.send(record, (recordMetadata, e) -> {
                // execute every time a record is sent or an exception is thrown
                Optional.ofNullable(e)
                        .ifPresentOrElse(
                                // error
                                exception -> log.error("Error in produce record", exception),
                                // success
                                () -> log.info("Received new metadata\n Key: {}, Topic: {}\n Partition: {}\n Offset: {}\n Timestamp: {}",
                                        record.key(),
                                        recordMetadata.topic(),
                                        recordMetadata.partition(),
                                        recordMetadata.offset(),
                                        recordMetadata.timestamp()
                                )
                        );
            });
        }

        // Flush Producer
        producer.flush();

        // Close Producer
        producer.close();
    }
}
