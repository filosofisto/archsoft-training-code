package com.archsoft;

public class CofeeEspresso extends ProductDecorator {

    private static final String DESCRIPTION = "Cofee Espresso";

    private static final double PRICE = 7;

    public CofeeEspresso() {
        super(DESCRIPTION, PRICE);
    }

    public CofeeEspresso(Product decorated) {
        super(decorated, DESCRIPTION, PRICE);
    }
}
