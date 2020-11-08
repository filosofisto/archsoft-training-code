package com.archsoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTest {

    @Test
    public void verificaConstrutorPadrao() {
        Pessoa p = new Pessoa();

        Assertions.assertNull(p.getNome());
        Assertions.assertEquals(0, p.getIdade());
    }

    @Test
    public void verificaConstrutorNomeIdade() {
        Pessoa p = new Pessoa("Edson", 35);

        Assertions.assertEquals("Edson", p.getNome());
        Assertions.assertEquals(35, p.getIdade());
    }
}
