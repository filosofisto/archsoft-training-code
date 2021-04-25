package com.archsoft;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class SomeTask {

    private final String taskName;

    public SomeTask(String taskName) {
        this.taskName = taskName;
    }

    public void perform() {
        out.println("Starting " + taskName);

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        out.println(taskName + " finished");
    }
}
