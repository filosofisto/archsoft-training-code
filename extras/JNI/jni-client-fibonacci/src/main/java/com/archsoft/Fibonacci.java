package com.archsoft;

public class Fibonacci {

    public native void fibonacciInit(long a, long b);

    public native boolean fibonacciNext();

    public native long fibonacciCurrent();

    public native int fibonacciIndex();

}
