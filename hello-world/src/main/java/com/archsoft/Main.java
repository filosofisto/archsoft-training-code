package com.archsoft;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        out.println("Hello Java");

        if (args.length == 2) {
            Calculator calculator = new Calculator();
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            out.printf("%s + %s = %s", a, b, calculator.add(a, b));
        }
    }
}
