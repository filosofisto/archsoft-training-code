package com.archsoft.model.customer;

import lombok.Data;

@Data
public class Address {

    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
}
