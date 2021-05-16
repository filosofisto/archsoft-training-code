package com.archsoft.to.customer;

import lombok.Data;

@Data
public class AddressTO {

    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
}
