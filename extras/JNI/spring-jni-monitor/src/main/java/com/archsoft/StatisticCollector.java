package com.archsoft;

public class StatisticCollector {

    public native int collectMemoryUsage();

    public native int collectCPUUsage();

    public native int collectProcessRunning();
}
