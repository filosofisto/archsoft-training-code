package com.archsoft.controller;

import com.archsoft.model.Statistic;
import com.archsoft.service.StatisticService;
import com.archsoft.to.StatisticAverageTO;
import com.archsoft.to.StatisticTO;
import com.archsoft.util.converter.StatisticConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/statistic")
public class StatController {

    private final StatisticService statisticService;

    private final StatisticConverter statisticConverter;

    @Autowired
    public StatController(StatisticService statisticService, StatisticConverter statisticConverter) {
        this.statisticService = statisticService;
        this.statisticConverter = statisticConverter;
    }

    @PostMapping
    public ResponseEntity<StatisticTO> create(@RequestBody StatisticTO statisticTO) {
        Statistic statistic = statisticService.create(statisticConverter.toEntity(statisticTO));

        return ResponseEntity.ok(statisticConverter.toTransferObject(statistic));
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<StatisticAverageTO> statistics() {
        StatisticAverageTO statisticAverageTO = statisticService.average();

        return ResponseEntity.ok(statisticAverageTO);
    }
}
