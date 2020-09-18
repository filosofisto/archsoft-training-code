package com.archsoft;

import org.apache.commons.lang.StringUtils;

import static java.lang.System.out;

public class Main {

    // Comentario
    public static void main(String[] args) {
        out.println("Hello Java");

        if (args.length == 2) {
            if (StringUtils.contains("1", 'a')) {

            }

            Calculator calculator = new Calculator();
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            out.printf("%d + %d = %d", a, b, calculator.add(a, b));
        }
    }
}
