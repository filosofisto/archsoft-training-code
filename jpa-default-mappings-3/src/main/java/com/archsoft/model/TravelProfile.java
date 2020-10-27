package com.archsoft.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class TravelProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_travelprofile")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
