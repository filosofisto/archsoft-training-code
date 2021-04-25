package com.archsoft;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class SharedFiFoQueue {

    private static final Logger log = Logger.getLogger(SharedFiFoQueue.class.getName());

    private String[] elems;
    private int current = 0;
    private int placeIndex = 0;
    private int removeIndex = 0;

    private final Lock lock = new ReentrantLock();
    private final Condition isEmpty = lock.newCondition();
    private final Condition isFull = lock.newCondition();

    public SharedFiFoQueue(int capacity) {
        this.elems = new String[capacity];
    }

    public void add(String elem) throws InterruptedException {
        lock.lock();
        log.info("add get LOCK");

        while (current >= elems.length) {
            log.info("Waiting for consuming...");
            isFull.await();
            log.info("Proceeding with add operation...");
        }

        elems[placeIndex] = elem;

        //We need the modulo, in order to avoid going out of bounds.
        placeIndex = (placeIndex + 1) % elems.length;

        ++current;

        //Notify the consumer that there is data available.
        log.info("Notifying that there is data for consume!");
        isEmpty.signal();

        lock.unlock();
        log.info("add release LOCK");
    }

    public String remove() throws InterruptedException {
        String elem;

        lock.lock();
        log.info("remove get lock");

        while (current <= 0) {
            log.info("Nothing to remove, let's wait");
            isEmpty.await();
            log.info("I can try remove now");
        }

        elem = elems[removeIndex];

        //We need the modulo, in order to avoid going out of bounds.
        removeIndex = (removeIndex + 1) % elems.length;

        --current;

        //Notify the producer that there is space available.
        log.info("Notify that there is space available");
        isFull.signal();

        lock.unlock();
        log.info("remove release LOCK");

        return elem;
    }
}
