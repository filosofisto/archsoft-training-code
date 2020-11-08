package com.archsoft;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
//        Validator<String> validatorCEP = new Validator<>() {
//
//            @Override
//            public boolean isValid(String s) {
//                return s.matches("[0-9]{5}-[0-9]{3}");
//            }
//        };

        Validator<String> validatorCEP = s -> s.matches("[0-9]{5}-[0-9]{3}");

        out.println("Valido: " + validatorCEP.isValid("71927-180"));
    }
}
