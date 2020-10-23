package com.archsoft.imp;

import com.archsoft.Exercise;

import static com.archsoft.Console.println;
import static com.archsoft.Console.readInt;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_11 extends Exercise {

	private static final String DESCRIPTION =
			"Construa um programa para ler do console um número e " +
			"informar se o mesmo é Primo";
	
	private static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		int limit = (int)Math.sqrt(n);
		for(int t = 2; t <= limit; t++) {
			if (n % t == 0) {
				return false;
			}
		}
		return true;
	}

	public Excercise_11() {
		super(DESCRIPTION);
	}
	
	@Override
	protected void doRun() {
		int n = readInt("Informe um número: ");
		
		String message = "é primo";
		
		if (!isPrime(n)) {
			message = "não " + message;
		}
		
		println(message);
	}
}
