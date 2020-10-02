package com.archsoft;

public class Main {

    public static void main(String[] args) {
        GStatistic gStatistic = new GStatistic();
        System.out.println("Max double: " + gStatistic.max(new Double[] { 7.0, 8.0, 0.5 }));

        System.out.println("Max int: " + gStatistic.max(new Integer[] { 7, 2, 5 }));

        System.out.println("Max float: " + gStatistic.max(new Float[] { 7f, 2f, 10f }));
    }
}
