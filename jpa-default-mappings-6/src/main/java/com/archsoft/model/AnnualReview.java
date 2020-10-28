package com.archsoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnnualReview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_annual_review")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
