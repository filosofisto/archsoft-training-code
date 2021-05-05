package com.archsoft.mongodb.to;

import com.archsoft.mongodb.model.Address;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CustomerTO {

    private String id;

    private String email;

    private String name;

    private Set<Address> addresses = new HashSet<>();
}
