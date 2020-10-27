package com.archsoft.model;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_employee")
    private Long id;

    @OneToOne
    private TravelProfile profile;

    public TravelProfile getProfile() {
        return profile;
    }
    public void setProfile(TravelProfile profile) {
        this.profile = profile;
    }
}
