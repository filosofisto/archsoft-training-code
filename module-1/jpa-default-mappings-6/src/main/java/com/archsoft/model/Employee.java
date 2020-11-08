package com.archsoft.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_employee")
    private Long id;

    @OneToMany
    private Collection<AnnualReview> annualReviews = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<AnnualReview> getAnnualReviews() {
        return annualReviews;
    }

    public void setAnnualReviews(Collection<AnnualReview> annualReviews) {
        this.annualReviews = annualReviews;
    }
}
