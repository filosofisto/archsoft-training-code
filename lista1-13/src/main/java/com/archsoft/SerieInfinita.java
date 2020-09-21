package com.archsoft;

public class SerieInfinita {

    private long timeExecution;

    public double calc(double precisao) {
        long t1 = System.currentTimeMillis();

        double valor = 1;
        double ultimoValor = 0;
        double denominador = 2;

        while ((valor - ultimoValor) > precisao) {
            ultimoValor = valor;

            valor = valor + 1/denominador;
            denominador *= 2;
        }

        long t2 = System.currentTimeMillis();
        timeExecution = t2-t1;

        return valor;
    }

    public long getTimeExecution() {
        return timeExecution;
    }
}
