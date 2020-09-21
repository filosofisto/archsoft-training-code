package com.archsoft;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Favor passar as notas via linha de comando");
            System.exit(-1);
        }

        float[] notas = new float[args.length];

        for (int i = 0; i < notas.length; i++) {
            notas[i] = Float.parseFloat(args[i]);
        }

        CalculadorNota calculadorNota = new CalculadorNota();
        float media = calculadorNota.mediaAritmetica(notas);

        if (media >= 6) {
            System.out.println("Aprovado");
        } else {
            System.out.println("Reprovado");
        }
    }
}
