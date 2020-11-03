package com.archsoft.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotBlank(message = "Nome requerido")
    @Column(name = "PERSON_NAME", nullable = false, length = 50)
    private String name;

    @NotNull(message = "Idade requerida")
    @Column(name = "PERSON_AGE", nullable = false)
    private Integer age;
}
