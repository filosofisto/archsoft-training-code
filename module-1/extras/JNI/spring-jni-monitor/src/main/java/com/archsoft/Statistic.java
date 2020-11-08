package com.archsoft;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Statistic {

    private Long id;
    private Integer cpuUsage;
    private Integer memoryUsage;
    private Integer processes;

}
