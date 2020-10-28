package com.archsoft.entity;

import javax.persistence.*;

@MappedSuperclass
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_employee")
    protected Integer id;

    @ManyToOne
    @JoinColumn(name="ADDR")
    protected Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
