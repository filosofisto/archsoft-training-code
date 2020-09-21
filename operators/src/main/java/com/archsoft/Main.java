package com.archsoft;

import static java.lang.System.*;

public class Main {

    private static char var;

    public static void main(String[] args) {
        //-----------------------------------
        //Atribuicao: =
        //-----------------------------------
        int x = 10;
        int y;

        y = x;

        out.println("x == y: " + (x == y));

        //-----------------------------------
        //Operadores logicos
        //-----------------------------------
        int a, b;
        a = 1;
        b = 2;

        if (b > a) {
            out.println("B maior que A");
        } else {
            out.println("B nao eh maiore que A");
        }

        if (a < b) {
            out.println("A menor que B");
        } else {
            out.println("A nao eh menor que B");
        }

        if (a == b) {
            out.println("A igual a B");
        } else {
            out.println("A nao eh igual a B");
        }

        if (a != b) {
            out.println("A eh diferente de B");
        } else {
            out.println("A eh igual B");
        }

        boolean k = false;
        out.println("k: " + k);
        out.println("~k: " + !k);
        out.println("~(~k) = k: " + ((!(!k)) == k));

        if (a != b && b > a) {
            out.println("A eh diferente de B E B eh maior do que A");
        } else {
            out.println("A eh igual a B OU A eh maior do que B");
        }

        if (a == b || b > a) {
            out.println("A eh igual a B OU B eh maior que A");
        }

        if (true) {
            out.println("Sempre imprimira esta mensagem");
        }

        if (false || true) {
            out.println("Sempre imprimira esta mensagem tambem");
        }

        var = 'B';
        if (1 == 1 || alteraVariavelERetornaTrue()) {
            out.printf("Gostaria que variavel fosse igual a 'A', mas o valor dela eh %s\n", var);
        }

        var = 'B';
        if (1 == 1 | alteraVariavelERetornaTrue()) {
            out.printf("Gostaria que variavel fosse igual a 'A', e o valor dela eh %s\n", var);
        }

        var = 'B';
        if (1 == 0 && alteraVariavelERetornaTrue()) {
            //Nunca entrara aqui
        } else {
            out.printf("Gostaria que variavel fosse igual a 'A', mas o valor dela eh %s\n", var);
        }

        var = 'B';
        if (1 == 0 & alteraVariavelERetornaTrue()) {
            //Nunca entrara aqui
        } else {
            out.printf("Gostaria que variavel fosse igual a 'A', e o valor dela eh %s\n", var);
        }

        //-----------------------------------
        //Operador ~ (inverte os bytes)
        //-----------------------------------
        byte bin = 0;
        out.println("bin: " + bin);
        out.println("~bin: " + ~bin);

        //-----------------------------------
        //Operador Ternario
        //-----------------------------------
        out.println((a > b) ? "A maior que B" : "A nao eh maior que B");
        out.println((a > b) ? "A maior que B" : (b > a) ? "B maior que A" : "Ambos sao iguais");

        //-----------------------------------
        //Incremento e Decremento
        //-----------------------------------
        a = 10;
        out.printf("Valor original de A: %d. \nApos o a++ o valor novo eh: %d, com ++a sera %d\n", a, a++, ++a);
        out.printf("Decrementando o valor de A teremos: %d\n", --a);

        //-----------------------------------
        //Matematicos
        //-----------------------------------
        a = 4;
        a = a * 3;
        out.printf("a * 3: %d\n", a);
        a = 4;
        a *= 3; // a = a * 3
        out.printf("a *= 3: %d\n", a);

        if (a % 2 == 0) {
            out.printf("%d eh par\n", a);
        } else {
            out.printf("%d eh impar\n", a);
        }

        //-----------------------------------
        //Binarios
        //-----------------------------------
        byte b1 = 11; // 0000 1011
        if ((b1 & 1) == 1) { // 0000 0001
            out.println("O bit 1 esta ON");
        }
        if ((b1 & 2) == 2) { // 0000 0010
            out.println("O bit 2 esta ON");
        }
        if ((b1 & 4) == 4) { // 0000 0100
            out.println("O bit 3 esta ON");
        }
        if ((b1 & 8) == 8) { // 0000 1000
            out.println("O bit 4 esta ON");
        }

        b1 = 1;
        b1 <<= 2; //Multiplicou por 4
        out.printf("%d 2 bits a esquerda (shift): %d", 1, b1);
    }

    private static boolean alteraVariavelERetornaTrue() {
        var = 'A';
        return true;
    }
}
