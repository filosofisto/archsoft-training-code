package com.archsoft.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Set;

@Document
public class Customer extends AbstractDocument {

    @Field("email")
    @Indexed(unique = true)
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private boolean enabled;

    @Getter
    @Setter
    private Set<Address> addresses = new HashSet<>();

    public void addAddress(Address address) {
        addresses.add(address);
    }

//    public Set<Address> getAddresses() {
//        return Collections.unmodifiableSet(addresses);
//    }
}
