package com.archsoft.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB008_FUNCIONARIO")
public class Funcionario extends Pessoa {

	@Column(name="SALARIO")
	private Double salario;

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario{" +
				"pessoa=" + super.toString() +
				", salario=" + salario +
				'}';
	}
}
