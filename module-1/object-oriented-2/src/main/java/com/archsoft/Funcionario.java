package com.archsoft;

public class Funcionario extends Pessoa {

    public Funcionario() {

    }

    public Funcionario(String nome, int idade, double salario) {
        super(nome, idade);
        this.salario = salario;
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

    public double calcBeneficio() {
        return getSalario() * 0.15;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Funcionario)) return false;

        boolean equalsPessoa = super.equals(obj);

        Funcionario other = (Funcionario) obj;

        boolean matriculaEquals = (matricula == null && other.getMatricula() == null)
                || matricula.equals(other.getMatricula());

        return equalsPessoa && salario == other.getSalario() && matriculaEquals;
    }

    @Override
    public String toString() {
        return super.toString() + ", Matricula: " + matricula + ", Salario: " + salario;
    }
}
