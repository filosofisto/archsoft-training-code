package com.archsoft;

import static java.lang.System.out;

public class Main {

    static {
        System.loadLibrary("stat");
    }

    public static void main(String[] args) {
        StatisticCollector collector = new StatisticCollector();

        out.println("Memoria Utilizada:       " + collector.collectMemoryUsage());
        out.println("CPU Utilizada:           " + collector.collectCPUUsage());
        out.println("Quantidade de processos: " + collector.collectProcessRunning());
    }
}
