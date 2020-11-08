package com.archsoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringMatcherTest {

    @Test
    public void isTrueLowercaseTest() {
        StringMatcher matcher = new StringMatcher();

        assertTrue(matcher.isTrueLowercase("true"));
        assertFalse(matcher.isTrueLowercase("True"));
    }

    @Test
    public void isTrueFirstCharAnyCaseTest() {
        StringMatcher matcher = new StringMatcher();

        assertTrue(matcher.isTrueFirstCharAnyCase("true"));
        assertTrue(matcher.isTrueFirstCharAnyCase("True"));
        assertFalse(matcher.isTrueFirstCharAnyCase("TRue"));
        assertFalse(matcher.isTrueFirstCharAnyCase("tRue"));
    }

    @Test
    public void isTrueOrYesTest() {
        StringMatcher matcher = new StringMatcher();

        assertTrue(matcher.isTrueOrYes("true"));
        assertTrue(matcher.isTrueOrYes("True"));
        assertTrue(matcher.isTrueOrYes("Yes"));
        assertTrue(matcher.isTrueOrYes("yes"));
    }

    @Test
    public void containsTrueTest() {
        StringMatcher matcher = new StringMatcher();

        assertTrue(matcher.containsTrue("indeed that true and True are the same"));
        assertFalse(matcher.containsTrue("There is only false here"));
    }

    @Test
    public void isThreeLettersTest() {
        StringMatcher matcher = new StringMatcher();

        assertTrue(matcher.isThreeLetters("xyz"));
        assertFalse(matcher.isThreeLetters("abcd"));
        assertFalse(matcher.isThreeLetters("ab3"));
    }
}
