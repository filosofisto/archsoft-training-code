package com.archsoft;

public class Main {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, 49);
        Pessoa p2 = new Pessoa("Eduardo", 49);

        if (p1.equals(p2)) {
            System.out.println("p1 eh igual a p2");
        } else {
            System.out.println("p1 eh diferente a p2");
        }

//        Pessoa p3 = null;
//        p3.getNome();
//
//        String eduardo = "";
//
//        if (p1.equals(eduardo)) {
//
//        }

//        if (p1 == p1) {
//
//        }
//
//        Object o = new Object();
//        Pessoa px = (Pessoa) o;
    }
}
