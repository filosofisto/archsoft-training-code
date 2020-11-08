package com.archsoft;

public class StringMatcher {

    public boolean isTrueLowercase(String str) {
        return str.matches("true");
    }

    public boolean isTrueFirstCharAnyCase(String str) {
        return str.matches("[Tt]rue");
    }

    public boolean isTrueOrYes(String str) {
        return str.matches("[Tt]rue|[Yy]es");
    }

    public boolean containsTrue(String str) {
        return str.matches(".*[Tt]rue.*");
    }

    public boolean isThreeLetters(String str) {
        return str.matches("[a-zA-Z]{3}");
    }
}
