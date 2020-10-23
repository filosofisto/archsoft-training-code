package com.archsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Pessoa("Leonardo", 28));
        pessoas.add(new Pessoa("Andreza", 18));
        pessoas.add(new Pessoa("Eduardo", 49));
        pessoas.add(new Pessoa("Caio", 49));

        Collections.sort(pessoas);

        printPessoas(pessoas);

        Collections.sort(pessoas, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                int result = o1.getIdade() - o2.getIdade();

                if (result == 0) {
                    result = -o1.getNome().compareTo(o2.getNome());
                }

                return result;
            }
        });

        printPessoas(pessoas);

        Collections.sort(pessoas, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return -o1.getNome().compareTo(o2.getNome());
            }
        });

        printPessoas(pessoas);

    }

    private static void printPessoas(List<Pessoa> pessoas) {
        for (Pessoa p: pessoas) {
            System.out.println(p);
        }
    }
}
