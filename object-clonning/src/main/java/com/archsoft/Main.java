package com.archsoft;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Cidade cidade = new Cidade();
        cidade.setNome("Porto Alegre");

        try {
            Cidade floripa = cidade.clone();
            out.println(floripa.getNome());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Pessoa p = new Pessoa();
        p.setNome("Chico");
        p.setCidade(cidade);

        try {
            Pessoa pClone = p.clone();
            pClone.getCidade().setNome("Nova York");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        out.println(p.getCidade().getNome());
    }
}
