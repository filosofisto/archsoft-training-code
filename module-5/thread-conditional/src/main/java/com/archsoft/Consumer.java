package com.archsoft;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class Consumer extends Thread {

    private static final Logger log = Logger.getLogger(Consumer.class.getName());

    private final Set<String> seenObjects = new HashSet<>();
    private int total = 0;
    private final SharedFiFoQueue queue;

    public Consumer(SharedFiFoQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            do {
                String obj = queue.remove();

                if (obj == null) {
                    break;
                }

                if (!seenObjects.contains(obj)) {
                    ++total;
                    seenObjects.add(obj);
                }

                log.info("[Consumer] Read the element: " + obj);
            } while (true);
        } catch (InterruptedException e) {
            log.severe("An InterruptedException was caught: " + e.getMessage());
            e.printStackTrace();
        }

        log.info("\n[Consumer] " + total + " distinct words have been read...");
    }
}
