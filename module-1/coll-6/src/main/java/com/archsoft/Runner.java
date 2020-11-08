package com.archsoft;

public class Runner {

    private long executionTime;

    public void execute(Runnable runnable) {
        long t1 = System.currentTimeMillis();

        runnable.run();

        long t2 = System.currentTimeMillis();
        executionTime = t2 - t1;
    }

    public long getExecutionTime() {
        return executionTime;
    }
}
