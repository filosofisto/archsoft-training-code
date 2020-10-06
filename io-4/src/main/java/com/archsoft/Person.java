package com.archsoft;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -6556432044645627956L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return getName();
    }
}
