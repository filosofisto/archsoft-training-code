package com.archsoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GerenteTest {

    @Test
    public void verificaSalario() {
        Gerente g = new Gerente("Fulano", 30, 30000, 5000);
        assertEquals(35000, g.getSalario());
    }

    @Test
    public void verificaCalcBeneficio() {
        Gerente g = new Gerente("Fulano", 30, 30000, 5000);
        assertEquals(5250, g.calcBeneficio());
    }
}
