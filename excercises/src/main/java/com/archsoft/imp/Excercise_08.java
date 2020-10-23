package com.archsoft.imp;

import com.archsoft.Exercise;

import java.util.stream.IntStream;

import static com.archsoft.Console.print;
import static com.archsoft.Console.println;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_08 extends Exercise {

	private static final String DESCRIPTION =
			"Construa um programa que imprime apenas os números pares entre 1 a 50";
	
	public Excercise_08() {
		super(DESCRIPTION);
	}

	@Override
	protected void doRun() {
		IntStream.range(1, 51).filter(n -> n % 2 == 0).forEach(n -> print(n + " "));
		println();
	}
}
