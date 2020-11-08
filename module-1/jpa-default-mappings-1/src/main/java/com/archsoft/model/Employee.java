package com.archsoft.model;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_employee")
    private Long id;

    @OneToOne
    private Cubicle assignedCubicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cubicle getAssignedCubicle() {
        return assignedCubicle;
    }

    public void setAssignedCubicle(Cubicle cubicle) {
        this.assignedCubicle = cubicle;
    }
}
