package com.archsoft;

import org.springframework.stereotype.Component;

@Component
public class StatisticCollector {

    public native int collectMemoryUsage();

    public native int collectCPUUsage();

    public native int collectProcessRunning();
}
