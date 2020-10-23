package com.archsoft.imp;

import com.archsoft.Exercise;

import static com.archsoft.Console.println;
import static com.archsoft.Console.readInt;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_02 extends Exercise {

	private static final String DESCRIPTION =
			"Construa um programa que leia a partir do console a idade " +
			"de uma pessoa expressa em anos, meses e dias e imprima no " +
			"console a idade expressa apenas em dias";
	
	public Excercise_02() {
		super(DESCRIPTION);
	}

	@Override
	protected void doRun() {
		int y = readInt("Digite os anos:");
		int m = readInt("Digite os meses:");
		int d = readInt("Digite os dias:");
		int r = d + (m * 30) + (y * 365);
		println("Solução: " + r + " dias");
	}
}
