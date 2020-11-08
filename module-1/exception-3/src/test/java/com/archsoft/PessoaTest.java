package com.archsoft;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PessoaTest {

    @Test
    public void idadeNegativa() {
        Pessoa p = new Pessoa();
        assertThrows(IdadeInvalidaException.class, () -> p.setIdade(-1));
    }
}
