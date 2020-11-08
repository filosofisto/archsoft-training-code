package com.archsoft;


public class Main {

    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Maradona");

        try {
            p.setIdade(-1);
        } catch (IdadeInvalidaException e) {
            System.out.println("Sr usuario lamento mas a idade nao eh valida");
        }

//        getValor();
    }

//    static boolean getValor() {
//        try {
//            return true;
//        } finally {
//            return false;
//        }
//    }
}
