package com.archsoft;

public class Cofee extends ProductDecorator {

    private static final String DESCRIPTION = "Cofee";

    private static final double PRICE = 5;

    public Cofee() {
        super(DESCRIPTION, PRICE);
    }

    public Cofee(Product decorated) {
        super(decorated, DESCRIPTION, PRICE);
    }
}
