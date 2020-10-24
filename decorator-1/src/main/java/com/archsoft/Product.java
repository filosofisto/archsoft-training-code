package com.archsoft;

import static java.lang.System.out;

public interface Product {

    String description();

    double price();

    default void showPrice() {
        out.printf("%s - Price: %.2f\n", description(), price());
    }
}
