package com.archsoft.imp;

import static com.archsoft.Console.println;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_05 extends Excercise_03 {

	private static final String DESCRIPTION =
			"Construa um programa que calcule a média aritmética das 3 notas de " +
			"um aluno e mostre, além do valor da média, uma mensagem de " +
			"\"Aprovado\", caso a média seja igual ou superior a 6, ou a mensagem " +
			"\"reprovado\", caso contrário. Ao invés de ler as notas do console, sorteie " +
			"(randomicamente) valores inteiros de 1 a 10";
	
	public Excercise_05() {
		super(DESCRIPTION);
	}

	protected int nextScore(String msg) {
		int n = 1 + RANDOMIZER.nextInt(10);
		println(msg + n);
		return n;
	}
	
	@Override
	protected float readN1() {
		return nextScore("Nota 1 sorteada: ");
	}
	
	@Override
	protected float readN2() {
		return nextScore("Nota 2 sorteada: ");
	}

	@Override
	protected float readN3() {
		return nextScore("Nota 3 sorteada: ");
	}
	
	protected void show(float avg) {
		println("média: " + avg);
		println(avg >= 6 ? "Aprovado" : "Reprovado");
	}
}
