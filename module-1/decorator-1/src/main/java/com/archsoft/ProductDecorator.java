package com.archsoft;

import java.util.Optional;

public abstract class ProductDecorator implements Product {

    private Product decorated;

    private String description;

    private double price;

    public ProductDecorator(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public ProductDecorator(Product decorated, String description, double price) {
        this.decorated = decorated;
        this.description = description;
        this.price = price;
    }

    @Override
    public String description() {
        return description + Optional.ofNullable(decorated)
                .map(decorated -> "+" + decorated.description())
                .orElse("");
    }

    @Override
    public double price() {
        return price + Optional.ofNullable(decorated)
                .map(decorated -> decorated.price())
                .orElse(0.0);
    }
}
