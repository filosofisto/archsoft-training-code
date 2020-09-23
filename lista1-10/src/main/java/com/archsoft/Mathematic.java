package com.archsoft;

/**
 * Classe com metodos static utilitarios para rotinas matematicas.
 *
 */
public class Mathematic {

    /**
     * Fatorial de um numero.
     *
     * @param n Numero que se deseja calcular o fatorial
     * @return Resultado final
     */
    public static long fat(int n) {
        long result = 1;

        for (int i = n; i > 1; i--) {
            result *= i;
        }

        return result;
    }

    /**
     * Fatorial de um numero usando recursividade.
     *
     * @param n Numero que se deseja calcular o fatorial
     * @return Resultado final
     */
    public static long rfat(int n) {
        if (n <= 1) {
            return 1;
        }

        return n*rfat(n-1);
    }
}
