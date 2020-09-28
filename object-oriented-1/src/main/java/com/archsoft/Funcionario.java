package com.archsoft;

public class Funcionario extends Pessoa {

    public Funcionario() {

    }

    public Funcionario(String nome, int idade) {
        super(nome, idade);
    }

    private String matricula;

    private double salario;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString() + ", Matricula: " + matricula + ", Salario: " + salario;
    }
}
