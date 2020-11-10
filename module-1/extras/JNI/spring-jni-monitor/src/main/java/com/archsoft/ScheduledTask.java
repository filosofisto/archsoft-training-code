package com.archsoft;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
@Slf4j
public class ScheduledTask {

//    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    @Value("${url}")
    private String url;

    private List<Statistic> statisticList;

    private final StatisticCollector statisticCollector;

    private RestTemplate restTemplate;

    @Autowired
    public ScheduledTask(StatisticCollector statisticCollector) {
        this.statisticCollector = statisticCollector;
        restTemplate = new RestTemplate();
        statisticList = new LinkedList<>();
    }

    @Scheduled(fixedRate = 2000)
    public void readStatistics() {
        Statistic statistic = createStatistic();
        logStatistic(statistic);
        sendStatistic(statistic, true);
    }

    private Statistic createStatistic() {
        return Statistic.builder()
                .cpuUsage(statisticCollector.collectCPUUsage())
                .memoryUsage(statisticCollector.collectMemoryUsage())
                .processes(statisticCollector.collectProcessRunning())
                .build();
    }

    private void logStatistic(Statistic statistic) {
        log.info("---");
        log.info("CPU Usage: {}%", statistic.getCpuUsage());
        log.info("Mem Usage: {}%", statistic.getMemoryUsage());
        log.info("Processes: {}", statistic.getProcesses());
    }

    private boolean sendStatistic(Statistic statistic, boolean addToListOnError) {
        boolean ret = true;

        try {
            HttpEntity<Statistic> entity = new HttpEntity<>(statistic, new HttpHeaders());
            Statistic statisticReturned = restTemplate.postForObject(url, entity, Statistic.class);

            if (Objects.nonNull(statisticReturned)) {
                log.info("Estatistica enviada para o servidor e gravada com id {}" + statisticReturned.getId());
            } else {
                throw new Exception("Erro ao tentar enviar estatistica para o servidor");
            }
        } catch (Exception e) {
            log.error(e.getMessage());

            if (addToListOnError) {
                log.warn("Estatistica salva temporariamente para posterior envio");
                statisticList.add(statistic);
            }

            ret = false;
        }

        return ret;
    }

    @Scheduled(fixedRate = 5000)
    public void retrySendStatistic() {
        statisticList.removeIf(statistic -> sendStatistic(statistic, false));
    }
}
