package com.archsoft.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Client {

    private String name;
    private Address address;
    private Phone phone;
    private Document document;
}
