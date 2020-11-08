package com.archsoft;

public class Milke extends ProductDecorator {

    private static final String DESCRIPTION = "Milke";

    private static final double PRICE = 2;

    public Milke() {
        super(DESCRIPTION, PRICE);
    }

    public Milke(Product decorated) {
        super(decorated, DESCRIPTION, PRICE);
    }
}
