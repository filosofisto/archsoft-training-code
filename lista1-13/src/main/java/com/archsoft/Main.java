package com.archsoft;

public class Main {

    public static void main(String[] args) {
        double precisao = 0.0000000001;
        SerieInfinita serieInfinita = new SerieInfinita();
        System.out.printf("Valor = %f\n", serieInfinita.calc(precisao));
        System.out.printf("Tempo de execucao = %d\n", serieInfinita.getTimeExecution());
    }
}
