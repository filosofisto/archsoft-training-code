package com.archsoft;

public class Main {

    public static void main(String[] args) {
        Runner runner = new Runner();
        SetRunnable runnable = new SetRunnable();
        runner.execute(runnable::run);

        System.out.printf("Tempo de processamento: %d ms\n", runner.getExecutionTime());
    }
}
