#include <stdio.h>
#include <unistd.h>
#include "cpu_usage.h"

/**
 * Read /proc/stat to get total_user, total_user_low, total_sys and total_idle
 * All these fields will be necessary to calc cpu usage
 */
cpu_stat_t read_cpu_stat()
{
    cpu_stat_t stat;
    FILE *file = fopen("/proc/stat", "r");
    fscanf(file, "cpu %llu %llu %llu %llu",
           &stat.total_user, &stat.total_user_low, &stat.total_sys, &stat.total_idle);
    fclose(file);

    return stat;
}

/**
 * Given two cpu stat read, calc diff in percentual terms.
 * -1 indicates a value that must be unconsider.
 */
int perc_cpu_stat(cpu_stat_t s1, cpu_stat_t s2)
{
    double perc;

    if (s2.total_user < s1.total_user || s2.total_user_low < s1.total_user_low
        || s2.total_sys < s1.total_sys || s2.total_idle < s1.total_idle)
        perc = -1;
    else {
        unsigned long long total = (s2.total_user - s1.total_user)
                                   + (s2.total_user_low - s1.total_user_low)
                                   + (s2.total_sys - s1.total_sys);
        perc = total;
        total += (s2.total_idle - s1.total_idle);

        if (total == 0) {
            perc = -1;
        } else {
            perc /= total;
            perc *= 100;
        }
    }

    return (int) perc;
}

/**
 * Make two call of read_cpu_stat to calc cpu usage.
 * That is the call to be used.
 */
int cpu_usage()
{
    cpu_stat_t s1 = read_cpu_stat();
    sleep(1); //TODO: 1 sec is too much to wait!!!
    cpu_stat_t s2 = read_cpu_stat();

    return perc_cpu_stat(s1, s2);
}

