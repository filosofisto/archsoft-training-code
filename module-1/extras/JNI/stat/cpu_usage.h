//
// Created by eduardo on 10/18/20.
//

#ifndef STAT_CPU_USAGE_H
#define STAT_CPU_USAGE_H

//type to store cpu stat fields
typedef struct cpu_metric
{
    unsigned long long total_user, total_user_low, total_sys, total_idle;
} cpu_stat_t;

//Get stat about CPU
cpu_stat_t read_cpu_stat();

//Calc diff between two read stat (read_cpu_stat)
int perc_cpu_stat(cpu_stat_t s1, cpu_stat_t s2);

//Calc CPU usage
int cpu_usage();

#endif //STAT_CPU_USAGE_H
