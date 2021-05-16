package com.archsoft.to.customer;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CustomerTO {

    private String id;

    private String email;

    private String name;

    private boolean enabled;

    private Set<AddressTO> addresses = new HashSet<>();
}
