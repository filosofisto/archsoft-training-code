package com.archsoft.service;

import com.archsoft.model.Statistic;
import com.archsoft.repository.StatisticRepository;
import com.archsoft.to.StatisticAverageTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;

    @Autowired
    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public Statistic create(Statistic statistic) {
        return statisticRepository.save(statistic);
    }

    public StatisticAverageTO average() {
        List<Statistic> all = statisticRepository.findAll();

        return StatisticAverageTO.builder()
                .cpuAverage(all.stream().mapToInt(Statistic::getCpuUsage).average().orElse(0.0))
                .memoryAverage(all.stream().mapToInt(Statistic::getMemoryUsage).average().orElse(0.0))
                .maxProcesses(all.stream().mapToInt(Statistic::getProcesses).max().orElse(0))
                .build();
    }
}
