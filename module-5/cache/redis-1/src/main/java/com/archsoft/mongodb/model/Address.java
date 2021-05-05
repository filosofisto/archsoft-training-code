package com.archsoft.mongodb.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {

    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
}
