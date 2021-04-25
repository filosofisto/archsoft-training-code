package com.archsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

public class CustomRecursiveTask extends RecursiveTask<Integer> {

    private static final Logger log = Logger.getLogger(CustomRecursiveTask.class.getName());

    private final int[] workload;
    private final int threshold;

    public CustomRecursiveTask(int[] workload, int threshold) {
        this.workload = workload;
        this.threshold = threshold;
    }

    @Override
    protected Integer compute() {
        if (workload.length > threshold) {
            return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        } else {
            return processing();
        }
    }

    private int processing() {
        return Arrays.stream(workload)
                .filter(a -> a > 10 && a < 27)
                .map(a -> a * 10)
                .sum();
    }

    private Collection<CustomRecursiveTask> createSubtasks() {
        List<CustomRecursiveTask> dividedTasks = new ArrayList<>();

        dividedTasks.add(new CustomRecursiveTask(
                Arrays.copyOfRange(workload, 0, workload.length / 2), threshold));
        dividedTasks.add(new CustomRecursiveTask(
                Arrays.copyOfRange(workload, workload.length / 2, workload.length), threshold));

        return dividedTasks;
    }
}
