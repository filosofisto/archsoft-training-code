package com.archsoft;

import static java.lang.System.out;

public class Main {

    static {
        System.loadLibrary("Fibonacci");
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        // Initialize a Fibonacci relation sequence.
        fibonacci.fibonacciInit(1, 1);

        // Write out the sequence values until overflow.
        do {
            out.println(fibonacci.fibonacciIndex() + ": " + fibonacci.fibonacciCurrent());
        } while (fibonacci.fibonacciNext());

        // Report count of values written before overflow.
        out.println(fibonacci.fibonacciIndex() + 1 +
                " Fibonacci sequence values fit in an " +
                "unsigned 64-bit integer.");
    }
}
