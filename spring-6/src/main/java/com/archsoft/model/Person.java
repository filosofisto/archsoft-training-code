package com.archsoft.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PERSON")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_person")
    private Long id;

    @Column(name = "PERSON_NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "PERSON_AGE", nullable = false)
    private int age;
}
