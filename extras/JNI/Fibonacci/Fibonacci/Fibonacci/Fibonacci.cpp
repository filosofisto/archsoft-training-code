#include "pch.h"
#include "com_archsoft_Fibonacci.h"
#include "MathLibrary.h"

JNIEXPORT jint JNICALL Java_com_archsoft_Fibonacci_fibonacciInit(JNIEnv* env, jobject obj, jlong a, jlong b)
{
	fibonacci_init(a, b);

	return 0;
}

JNIEXPORT jboolean JNICALL Java_com_archsoft_Fibonacci_fibonacciNext(JNIEnv* env, jobject obj)
{
	return fibonacci_next();
}

JNIEXPORT jlong JNICALL Java_com_archsoft_Fibonacci_fibonacciCurrent(JNIEnv* env, jobject obj)
{
	return fibonacci_current();
}

JNIEXPORT jint JNICALL Java_com_archsoft_Fibonacci_fibonacciIndex(JNIEnv* env, jobject obj)
{
	return fibonacci_index();
}