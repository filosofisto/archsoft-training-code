package com.archsoft.imp;

import com.archsoft.Exercise;

import static com.archsoft.Console.println;
import static com.archsoft.Console.readInt;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_09 extends Exercise {

	private static final String DESCRIPTION =
			"Construa um programa que leia dois números inteiros, X e Y, e " +
			"mostre o resultado de X elevado a potência Y";
	
	public Excercise_09() {
		super(DESCRIPTION);
	}

	@Override
	protected void doRun() {
		int x = readInt("Digite X: ");
		int y = readInt("Digite Y: ");
		
		println("Resultado: " + Math.pow(x, y));
	}
}
