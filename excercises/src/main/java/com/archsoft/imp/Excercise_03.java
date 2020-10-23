package com.archsoft.imp;

import com.archsoft.Exercise;

import static com.archsoft.Console.println;
import static com.archsoft.Console.readFloat;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_03 extends Exercise {

	private static final String DESCRIPTION =
			"Construa um programa que leia a partir do console as 3 " +
			"notas de um aluno e calcule a média final deste aluno, " +
			"considerando média aritmética simples";
	
	public Excercise_03() {
		this(DESCRIPTION);
	}
	
	protected Excercise_03(String description) {
		super(description);
	}
	
	@Override
	protected void doRun() {
		float n1 = readN1();
		float n2 = readN2();
		float n3 = readN3();
		
		float m = computeAvg(n1, n2, n3);
		
		show(m);
	}
	
	protected float readN1() {
		return readFloat("Digite nota 1: ");
	}
	
	protected float readN2() {
		return readFloat("Digite nota 2: ");
	}

	protected float readN3() {
		return readFloat("Digite nota 3: ");
	}

	protected float computeAvg(float n1, float n2, float n3) {
		return (n1 + n2 + n3)/3f;
	}
	
	protected void show(float avg) {
		println("média: " + avg);
	}
}
