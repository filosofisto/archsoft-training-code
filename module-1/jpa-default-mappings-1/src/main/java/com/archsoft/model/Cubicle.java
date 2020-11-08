package com.archsoft.model;

import javax.persistence.*;

@Entity
public class Cubicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_cubicle")
    private Long id;

    @OneToOne(mappedBy="assignedCubicle")
    private Employee residentEmployee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getResidentEmployee() {
        return residentEmployee;
    }

    public void setResidentEmployee(Employee employee) {
        this.residentEmployee = employee;
    }
}
