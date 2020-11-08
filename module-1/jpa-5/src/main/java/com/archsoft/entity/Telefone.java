package com.archsoft.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TB003_TELEFONE")
public class Telefone implements Serializable {

	private static final long serialVersionUID = -5830259434500265141L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_telefone")
	@Column(name="ID_TELEFONE")
	private Long id;
	
	@Column(name="PAIS")
	private Integer pais;
	
	@Column(name="AREA", nullable=false)
	private Integer area;
	
	@Column(name="TELEFONE", nullable=false)
	private Long telefone;
	
	@ManyToOne
	@JoinColumn(name="ID_PESSOA")
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPais() {
		return pais;
	}

	public void setPais(Integer pais) {
		this.pais = pais;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	
	/*public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}*/

	@Override
	public String toString() {
		return getPais() + " " + getArea() + " " + getTelefone();
	}
}
