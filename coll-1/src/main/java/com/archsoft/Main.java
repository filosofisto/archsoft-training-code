package com.archsoft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Joao Paulo");
        list.add("Francisco");
        list.add("Pietro");

        // Implementacao de Consumer (anonimo)
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                out.println(s);
            }
        });

        // Implementacao usando lambda
        list.forEach(s -> out.println(s));

        // Implementacao usando Method Reference
        list.forEach(out::println);

        // Iterator
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().length() < 7) {
                it.remove();
            }
        }

        list.forEach(out::println);

        out.println("------------------------------------");

        // Usando Stream, filtrando e gerando uma nova colecao
        list.stream()
                .filter(s -> s.length() >= 7)
//                .collect(Collectors.toList())
                .forEach(out::println);
    }
}
