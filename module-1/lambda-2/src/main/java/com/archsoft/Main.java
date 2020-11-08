package com.archsoft;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        final int x = 5;
        int y = 7;

        new Thread(() -> {
            out.println(x);
            out.println(y);
        });

        // Se a linha abaixo existir, y nao sera mais Efetivamente Final
//        y = 8;
    }
}
