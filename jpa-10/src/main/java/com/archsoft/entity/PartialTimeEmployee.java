package com.archsoft.entity;

import javax.persistence.*;

@Entity
@Table(name="PT_EMP")
@AssociationOverride(name="address", joinColumns=@JoinColumn(name="ADDR_ID"))
public class PartialTimeEmployee extends Employee {

    @Column(name="WAGE")
    protected Float hourlyWage;

    public Float getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Float hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
