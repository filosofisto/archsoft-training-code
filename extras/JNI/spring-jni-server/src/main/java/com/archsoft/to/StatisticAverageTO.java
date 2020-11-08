package com.archsoft.to;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatisticAverageTO {

    private double cpuAverage;
    private double memoryAverage;
    private int maxProcesses;
}
