package com.archsoft.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB001_PESSOA")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = -7587306736125891447L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_pessoa")
    @Column(name = "ID_PESSOA")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    //@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ID_ENDERECO")
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
