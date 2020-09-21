package com.archsoft;

public class CalculadorNota {

    public float mediaAritmetica(float[] notas) {
        if (notas.length == 0) {
            return 0f;
        }

        float sum = 0f;

        for (float value: notas) {
            sum += value;
        }

        return sum / notas.length;
    }
}
