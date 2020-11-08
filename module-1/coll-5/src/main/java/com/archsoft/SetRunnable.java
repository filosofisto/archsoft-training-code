package com.archsoft;

import java.util.*;

import static java.lang.System.out;

public class SetRunnable implements Runnable {

    private Set<Veiculo> set;

    public SetRunnable() {
        this.set = new LinkedHashSet<>();
    }

    @Override
    public void run() {
        populate();
        show();
    }

    private void populate() {
        int renavam;

        for (int i = 500; i > 0; i--) {
            if (i % 2 == 0) {
                renavam = i-1;
            } else {
                renavam = i;
            }

            Veiculo v = new Veiculo(renavam);
            boolean adicionou = set.add(v);
            set.add(null);
            out.printf("Adicionou veiculo %d, %b\n", renavam, adicionou);
        }
    }

    private void show() {
        out.println("Lista de Veiculos");

//        for (Veiculo v: set) {
//            if (Objects.nonNull(v)) {
//                out.printf("veiculo: %s\n", v.getRenavam());
//            }
//        }

        set.stream()
                .filter(Objects::nonNull)
                .forEach(veiculo -> out.printf("veiculo: %s\n", veiculo.getRenavam()));

//        set.forEach(veiculo -> {
//            Optional.ofNullable(veiculo)
//                    .ifPresentOrElse(
//                            v -> out.printf("veiculo: %s\n", v.getRenavam()),
//                            () -> out.println("veiculo: null"));
//        });
    }
}
