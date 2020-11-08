package com.archsoft;

public class Gerente extends Funcionario {

    private double ajudaCusto;

    public Gerente(String nome, int idade, double salario, double ajudaCusto) {
        super(nome, idade, salario);
        this.ajudaCusto = ajudaCusto;
    }

    @Override
    public double getSalario() {
        return super.getSalario() + ajudaCusto;
    }
}
