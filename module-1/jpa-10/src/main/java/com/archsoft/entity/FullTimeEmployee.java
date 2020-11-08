package com.archsoft.entity;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

    protected Double salary;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
