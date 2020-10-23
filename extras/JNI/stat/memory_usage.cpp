#include "memory_usage.h"

/**
 * Returns memory usage percentual
 */
int memory_usage()
{
    struct sysinfo memInfo;

    if (sysinfo(&memInfo) < 0) return -1;

    //Total Memoria Virtual
    long long total_virtual_mem = memInfo.totalram;
    total_virtual_mem += memInfo.totalswap;
    total_virtual_mem *= memInfo.mem_unit;

    //Total Memoria Usada
    long long total_virtual_mem_used = memInfo.totalram - memInfo.freeram;
    total_virtual_mem_used += memInfo.totalswap - memInfo.freeswap;
    total_virtual_mem_used *= memInfo.mem_unit;

    //printf("Total Mem Used: %lld bytes\n", total_virtual_mem_used);

    double perc = (((double) total_virtual_mem_used) / ((double) total_virtual_mem)) * 100.0;

    int perc_i = (int) perc;

    return perc_i;
}
