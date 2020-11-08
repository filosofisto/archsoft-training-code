package com.archsoft.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CPU_USAGE", nullable = false, length = 3)
    private Integer cpuUsage;

    @Column(name = "MEMORY_USAGE", nullable = false, length = 3)
    private Integer memoryUsage;

    @Column(name = "PROCESSES", nullable = false, length = 3)
    private Integer processes;

}
