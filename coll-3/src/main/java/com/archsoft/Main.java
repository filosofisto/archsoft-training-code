package com.archsoft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Um");
        list.add("Dois");
        list.add("Um");

        list.forEach(out::println);

        out.printf("Segundo item: %s\n", list.get(1));

        out.println("---------------------------------------");
        list.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(out::println);

        Pessoa p1 = new Pessoa("Aurelio", 40);
        Pessoa p2 = new Pessoa("Anderson", 45);
        Pessoa p3 = new Pessoa("Camila", 42);
        Pessoa p4 = new Pessoa("Anderson", 39);

        List<Pessoa> pessoas = List.of(p1, p2, p3, p4);

        out.println("---------------------------------------");
        pessoas.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(out::println);

        out.println("---------------------------------------");
        pessoas.stream()
                .sorted(new Comparator<Pessoa>() {
                    @Override
                    public int compare(Pessoa o1, Pessoa o2) {
                        return o1.getIdade()-o2.getIdade();
                    }
                })
                .forEach(out::println);

        out.println("---------------------------------------");
        pessoas.stream()
                .sorted(Comparator.comparing(Pessoa::getIdade))
                .forEach(out::println);

        out.println("---------------------------------------");
        pessoas.stream()
                .sorted(Comparator.comparing(Pessoa::getIdade).reversed())
                .forEach(out::println);

        out.println("---------------------------------------");
        pessoas.stream()
                .sorted(Comparator.comparing(Pessoa::getNome)
                        .thenComparing(Pessoa::getIdade))
                .forEach(out::println);
    }
}
