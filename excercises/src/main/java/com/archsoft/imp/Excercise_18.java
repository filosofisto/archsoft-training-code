package com.archsoft.imp;

import com.archsoft.Exercise;

import static com.archsoft.Console.print;
import static com.archsoft.Console.println;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_18 extends Exercise {

	private static final String DESCRIPTION = "Construa um algoritmo para exibir os números da série de Fibonacci";
	
	private static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public Excercise_18() {
		super(DESCRIPTION);
	}
	
	@Override
	protected void doRun() {
		int n = RANDOMIZER.nextInt(10);
		println("Os " + n + " primeiros termos de fibonacci são: ");
		for(int i = 0; i < n; i++) {
			print(fibonacci(i) + " ");
		}
		println();
	}
}
