#include <sys/types.h>
#include <sys/sysinfo.h>
#include "com_archsoft_StatisticCollector.h"

extern int memory_usage();
extern int cpu_usage();
extern int processes();

JNIEXPORT jint JNICALL Java_com_archsoft_StatisticCollector_collectMemoryUsage(JNIEnv *, jobject)
{
    return memory_usage();
}

JNIEXPORT jint JNICALL Java_com_archsoft_StatisticCollector_collectCPUUsage(JNIEnv *, jobject)
{
    return cpu_usage();
}

JNIEXPORT jint JNICALL Java_com_archsoft_StatisticCollector_collectProcessRunning(JNIEnv *, jobject)
{
    return processes();
}

