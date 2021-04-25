package com.archsoft;

public class Main {

    public static void main(String[] args) {
        try {
            SharedFiFoQueue sharedQueue = new SharedFiFoQueue(10);

            //Create a producer and a consumer.
            Thread producer = new Producer(args[0], sharedQueue);
            Thread consumer = new Consumer(sharedQueue);

            //Start both threads.
            producer.start();
            consumer.start();

            //Wait for both threads to terminate.
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
