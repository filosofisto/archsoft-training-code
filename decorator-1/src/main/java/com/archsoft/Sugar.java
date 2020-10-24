package com.archsoft;

public class Sugar extends ProductDecorator {

    private static final String DESCRIPTION = "Sugar";

    private static final double PRICE = 0.5;

    public Sugar() {
        super(DESCRIPTION, PRICE);
    }

    public Sugar(Product decorated) {
        super(decorated, DESCRIPTION, PRICE);
    }
}
