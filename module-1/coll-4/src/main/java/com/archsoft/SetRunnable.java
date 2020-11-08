package com.archsoft;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static java.lang.System.out;

public class SetRunnable implements Runnable {

    private Set<Veiculo> set;

    public SetRunnable() {
        this.set = new HashSet<>();
    }

    @Override
    public void run() {
        populate();
        show();
    }

    private void populate() {
        int renavam;

        for (int i = 1; i <= 500; i++) {
            if (i % 2 == 0) {
                renavam = i-1;
            } else {
                renavam = i;
            }

            Veiculo v = new Veiculo(renavam);
            boolean adicionou = set.add(v);
            out.printf("Adicionou veiculo %d, %b\n", renavam, adicionou);
        }

        set.add(null);
        set.add(null);
        set.add(null);
    }

    private void show() {
        out.println("Lista de Veiculos");

//        for (Veiculo v: set) {
//            if (Objects.nonNull(v)) {
//                out.printf("veiculo: %s\n", v.getRenavam());
//            } else {
//                out.println("veiculo: null");
//            }
//        }

        set.forEach(veiculo -> {
            Optional.ofNullable(veiculo)
                    .ifPresentOrElse(
                            v -> out.printf("veiculo: %s\n", v.getRenavam()),
                            () -> out.println("veiculo: null"));

//            if (Objects.nonNull(veiculo)) {
//                out.printf("veiculo: %s\n", veiculo.getRenavam());
//            } else {
//                out.println("veiculo: null");
//            }
        });
    }
}
