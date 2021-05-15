package com.archsoft.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class ConsumerRunnable implements Runnable {

    private final static Logger log = LoggerFactory.getLogger(ConsumerRunnable.class);

    private final String topic;
    private final CountDownLatch latch;
    private final Properties properties;
    private final KafkaConsumer<String, String> consumer;

    public ConsumerRunnable(String bootstrapServer, String topic, String groupId,
                            String autoOffsetResetConfig, CountDownLatch latch) {
        this.topic = topic;
        this.latch = latch;

        properties = new Properties();

        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetResetConfig);

        consumer = new KafkaConsumer<>(properties);
    }

    @Override
    public void run() {
        try {
            // Subscripe into topics
            consumer.subscribe(Collections.singleton(topic));

            while (true) {
                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(100));

                consumerRecords.forEach(record -> log.info("Key: {}, Value: {}, Partition: {}, Offset: {}",
                        record.key(), record.value(), record.partition(), record.offset()));
            }
        } catch (WakeupException e) {
            log.error("Received shutdown signal");
        } finally {
            consumer.close();
            latch.countDown();
        }
    }

    public void shutdown() {
        consumer.wakeup();
    }
}
