package com.archsoft;

public class Chantilly extends ProductDecorator {

    private static final String DESCRIPTION = "Chantilly";

    private static final double PRICE = 1.5;

    public Chantilly() {
        super(DESCRIPTION, PRICE);
    }

    public Chantilly(Product decorated) {
        super(decorated, DESCRIPTION, PRICE);
    }
}
