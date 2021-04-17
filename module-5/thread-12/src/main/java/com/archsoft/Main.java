package com.archsoft;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newWorkStealingPool();

        CountDownLatch countDownLatch = new CountDownLatch(3);

        pool.submit(() -> {
            new SomeTask("Task 1").perform();
            countDownLatch.countDown();
        });
        pool.submit(() -> {
            new SomeTask("Task 2").perform();
            countDownLatch.countDown();
        });
        pool.submit(() -> {
            new SomeTask("Task 3").perform();
            countDownLatch.countDown();
        });

        try {
            // The Last Task will execute if timeout does not occurs
            if (countDownLatch.await(1000, TimeUnit.MILLISECONDS)) {
                new SomeTask("Last Task").perform();
            } else {
                // here I want wait other tasks
                countDownLatch.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
