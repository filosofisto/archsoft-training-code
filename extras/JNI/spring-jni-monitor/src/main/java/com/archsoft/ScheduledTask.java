package com.archsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    private final StatisticCollector statisticCollector;

    public ScheduledTask() {
        this.statisticCollector = new StatisticCollector();
    }

    @Scheduled(fixedRate = 2000)
    public void readStatistics() {
        log.info("---");
        log.info("CPU Usage: {}%", statisticCollector.collectCPUUsage());
        log.info("Mem Usage: {}%", statisticCollector.collectMemoryUsage());
        log.info("Processes: {}", statisticCollector.collectProcessRunning());
    }
}
