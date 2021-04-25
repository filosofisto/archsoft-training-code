package com.archsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

public class CustomRecursiveAction extends RecursiveAction {

    private static final Logger log = Logger.getLogger(CustomRecursiveAction.class.getName());

    private final String workload;
    private final int threshold;

    public CustomRecursiveAction(String workload, int threshold) {
        this.workload = workload;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if (workload.length() > threshold) {
            ForkJoinTask.invokeAll(createSubtasks());
        } else {
            processing();
        }
    }

    private void processing() {
        String result = workload.toUpperCase();

        log.info("This result - (" + result + ") was processed by thread "
                + Thread.currentThread().getName());
    }

    private List<CustomRecursiveAction> createSubtasks() {
        List<CustomRecursiveAction> subtasks = new ArrayList<>();

        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2);

        subtasks.add(new CustomRecursiveAction(partOne, threshold));
        subtasks.add(new CustomRecursiveAction(partTwo, threshold));

        return subtasks;
    }

}
