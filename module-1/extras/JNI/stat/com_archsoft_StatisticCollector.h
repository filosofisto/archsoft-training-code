/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_archsoft_StatisticCollector */

#ifndef _Included_com_archsoft_StatisticCollector
#define _Included_com_archsoft_StatisticCollector
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_archsoft_StatisticCollector
 * Method:    collectMemoryUsage
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_archsoft_StatisticCollector_collectMemoryUsage
  (JNIEnv *, jobject);

/*
 * Class:     com_archsoft_StatisticCollector
 * Method:    collectCPUUsage
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_archsoft_StatisticCollector_collectCPUUsage
  (JNIEnv *, jobject);

/*
 * Class:     com_archsoft_StatisticCollector
 * Method:    collectProcessRunning
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_archsoft_StatisticCollector_collectProcessRunning
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif