package com.archsoft.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_ENDERECO")
    private Endereco endereco;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="pessoa", orphanRemoval=true, cascade=CascadeType.ALL)
    private List<Telefone> telefones = new ArrayList<>();

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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
