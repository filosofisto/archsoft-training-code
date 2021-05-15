package com.archsoft.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class ConsumerDemo {

    private static final Logger log = LoggerFactory.getLogger(ConsumerDemo.class);

    private static final String BOOTSTRAP_SERVER = "127.0.0.1:9092";
    private static final String TOPIC = "first_topic";
    private static final String GROUP_ID = "Group-Kafka-5";
    public static final String AUTO_OFFSET_RESET_CONFIG = "earliest";

    public static void main(String[] args) {
        log.info("Creating consumer, group {}, topic {}", TOPIC, GROUP_ID);

        CountDownLatch latch = new CountDownLatch(1);
        ConsumerRunnable consumerRunnable = new ConsumerRunnable(
                BOOTSTRAP_SERVER,
                TOPIC,
                GROUP_ID,
                AUTO_OFFSET_RESET_CONFIG,
                latch);
        Thread t = new Thread(consumerRunnable);
        t.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Shutting down...");
            consumerRunnable.shutdown();

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info("The end");
        }));

        try {
            latch.await();
        } catch (InterruptedException e) {
            log.error("Program was interrupted", e);
        } finally {
            log.info("Application terminating");
        }
    }
}
