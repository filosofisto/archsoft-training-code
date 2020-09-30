package com.archsoft;

public class Main {

    public static void main(String[] args) {
        Retangulo r = new Quadrado();
        r.setAltura(10);
        r.setBase(20);

        // far from here

        if (r instanceof Quadrado) {
            // faz alguma coisa
        } else {
            // trato como retangulo
        }
    }
}
