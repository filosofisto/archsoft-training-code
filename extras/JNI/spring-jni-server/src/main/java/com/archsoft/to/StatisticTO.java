package com.archsoft.to;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StatisticTO {

    private Long id;
    private Integer cpuUsage;
    private Integer memoryUsage;
    private Integer processes;
}
