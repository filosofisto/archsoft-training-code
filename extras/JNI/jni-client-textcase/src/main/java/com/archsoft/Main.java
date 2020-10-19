package com.archsoft;

import static java.lang.System.out;

public class Main {

    static {
        System.loadLibrary("TextCase");
    }

    public static void main(String[] args) {
        TextCase textCase = new TextCase();

        out.println("upcase -> " + textCase.upcase("call dll"));
        out.println("lowcase -> " + textCase.lowcase("CALL DLL"));
    }
}
