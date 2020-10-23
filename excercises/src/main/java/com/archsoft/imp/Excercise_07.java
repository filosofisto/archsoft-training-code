package com.archsoft.imp;

import com.archsoft.Exercise;

import java.util.Comparator;
import java.util.stream.IntStream;

import static com.archsoft.Console.print;
import static com.archsoft.Console.println;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_07 extends Exercise {

	private static final String DESCRIPTION =
			"Construa um programa que imprime os números de 1 a 50 em " +
			"ordem crescente e também em ordem decrescente";
	
	public Excercise_07() {
		super(DESCRIPTION);
	}

	@Override
	protected void doRun() {
		println("Crescente");
		IntStream.range(1, 51).forEach(n -> print(n + " "));

		println();
		
		println("Decrescente");
		IntStream.range(1, 51).boxed().sorted(Comparator.reverseOrder()).forEach(n -> print(n + " "));
	}
}
