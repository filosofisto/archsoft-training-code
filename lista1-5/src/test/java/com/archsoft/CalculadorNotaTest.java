package com.archsoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadorNotaTest {

    @Test
    public void mediaAritmeticaSimples() {
        CalculadorNota calculadorNota = new CalculadorNota();
        Assertions.assertEquals(8f, calculadorNota.mediaAritmetica(new float[] {7f, 8f, 9f}));
    }

    @Test
    public void mediaAritmeticaArrayVazio() {
        CalculadorNota calculadorNota = new CalculadorNota();
        Assertions.assertEquals(0f, calculadorNota.mediaAritmetica(new float[] { }));
    }
}
