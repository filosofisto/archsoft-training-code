package com.archsoft;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int sorteado = random.nextInt(20) + 1;

        System.out.printf("Fatorial de %d = %d\n", sorteado, Mathematic.fat(sorteado));
    }
}
