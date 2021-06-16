package com.archsoft;

import static java.lang.System.out;

public class Transaction extends Thread {

    private final String id;
    private final Account from;
    private final Account to;
    private final double amount;

    public Transaction(String id, Account from, Account to, double amount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        // Acquire the lock of Account 'from'
        synchronized (from) {
            out.printf("Thread %s locked from\n", Thread.currentThread().getName());
            from.withdraw(amount);

//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) { }

            // Acquire the lock of Account 'to'
            synchronized (to) {
                out.printf("Thread %s locked to\n", Thread.currentThread().getName());
                to.deposit(amount);
            }
            out.printf("Thread %s unlocked to\n", Thread.currentThread().getName());
            // Release the lock of Account 'to'
        }

        out.printf("Thread %s unlocked from\n", Thread.currentThread().getName());
        // Release the lock of Account 'from'
        out.println(amount + " is transfered from " + from + " to " + to);
    }
}
