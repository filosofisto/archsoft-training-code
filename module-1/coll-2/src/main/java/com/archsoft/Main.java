package com.archsoft;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();

        coll.add("Joao Paulo");
        coll.add("Francisco");
        coll.add("Pietro");

        out.printf("Size: %d\n", coll.size());
        out.println("Empty: " + (coll.isEmpty() ? "true" : "false"));

        out.println("-------------------------------");
        Collection<String> coll2 = new ArrayList<>();
        coll2.addAll(coll);
        coll2.forEach(out::println);

        out.println("coll contain 'Pietro'? " + coll.contains("Pietro"));
        out.println("coll contain 'Ubaldi'? " + coll.contains("Ubaldi"));

        out.println("-------------------------------");
        Object[] array = coll.toArray();
        for (int i = 0; i < array.length; i++) {
            out.println(array[i]);
        }

        out.println("-------------------------------");
        String[] sarray = new String[coll.size()];
        coll.toArray(sarray);
        for (int i = 0; i < array.length; i++) {
            out.println(array[i]);
        }

        out.println("-------------------------------");
        coll.remove("Francisco");
        coll.forEach(out::println);
    }
}
