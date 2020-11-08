package com.archsoft;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class Main {

    private static final String EXAMPLE_TEST =
            "Exemplo de frase com palavras e numeros tais como 100, 200, 300 a ser processada usando Pattern and Matcher";

    public static void main(String[] args) {
//        Pattern patternNumbers = Pattern.compile("\\d+");
//        showResult(patternNumbers);

        Pattern patternWords = Pattern.compile("\\w+", Pattern.CASE_INSENSITIVE);
        showResult(patternWords);
    }

    private static void showResult(Pattern pattern) {
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);

        while (matcher.find()) {
            out.print("Start: " + matcher.start());
            out.print(" End: " + matcher.end() + " ");
            out.println(matcher.group());
        }
    }
}
