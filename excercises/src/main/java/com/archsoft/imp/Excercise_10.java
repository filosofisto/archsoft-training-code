package com.archsoft.imp;

import com.archsoft.Console;
import com.archsoft.Exercise;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_10 extends Exercise {

	private static final String DESCRIPTION =
			"Construa um programa que sorteie um número entre 1 e 20 e " +
			"retorne o Fatorial do mesmo";
	
	private static int fatorial(int n) {
		return n <= 0 ? 1 : (n * fatorial(n-1));
	}
	
	public Excercise_10() {
		this(DESCRIPTION);
	}
	
	protected Excercise_10(String description) {
		super(description);
	}
	
	@Override
	protected void doRun() {
		int n = 1 + RANDOMIZER.nextInt(20);
		int f = fatorial(n);
		Console.println("Sorteado " + n + " fatorial: " + f);
	}
}

