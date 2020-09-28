package com.archsoft;

import com.archsoft.calcbeneficio.CalcBeneficioStrategy;

public class Funcionario extends Pessoa {

    private String matricula;

    private double salario;

    private CalcBeneficioStrategy calcBeneficioStrategy;

    public Funcionario() {

    }

    public Funcionario(String nome, int idade, double salario) {
        super(nome, idade);
        this.salario = salario;
    }

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

    public void setCalcBeneficioStrategy(CalcBeneficioStrategy calcBeneficioStrategy) {
        this.calcBeneficioStrategy = calcBeneficioStrategy;
    }

    public double calcBeneficio(double... outrosValores) {
        return calcBeneficioStrategy.calculaBeneficio(this, outrosValores);
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
