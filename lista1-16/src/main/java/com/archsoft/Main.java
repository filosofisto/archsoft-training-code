package com.archsoft;

import java.util.Random;

public class Main {

    public static final int TAMANHO_ARRAY = 100;
    public static final int POSICAO_NAO_ENCONTRADA = -1;

    public static void main(String[] args) {
        Random random = new Random();

        // Popular o array
        int[] array = new int[TAMANHO_ARRAY];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(TAMANHO_ARRAY) + 1;
        }

        int procurarPor = random.nextInt(TAMANHO_ARRAY) + 1;
        int posicao = POSICAO_NAO_ENCONTRADA;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == procurarPor) {
                posicao = i;
                break;
            }
        }

        if (posicao != POSICAO_NAO_ENCONTRADA) {
            System.out.printf("Numero %d encontrado na posicao %d\n", procurarPor, posicao);
        } else {
            System.out.printf("Numero %d nao encontrado\n", procurarPor);
        }
    }
}
