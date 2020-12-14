package com.archsoft.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "TB02_PERSON")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 4087182321318240446L;

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
