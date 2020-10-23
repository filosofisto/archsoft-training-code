package com.archsoft.imp;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_04 extends Excercise_03 {

	private static final String DESCRIPTION =
			"Construa um programa que leia a partir do console as 3 notas " +
			"de um aluno e calcule a média final deste aluno. Considerar que " +
			"a média é ponderada e que o peso das notas são 2,3 e 5, respectivamente";
	
	public Excercise_04() {
		super(DESCRIPTION);
	}
	
	@Override
	protected float computeAvg(float n1, float n2, float n3) {
		return (2*n1 + 3*n2 + 5*n3)/10f;
	}
}
