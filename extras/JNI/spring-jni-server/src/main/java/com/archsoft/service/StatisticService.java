package com.archsoft.service;

import com.archsoft.model.Statistic;
import com.archsoft.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
