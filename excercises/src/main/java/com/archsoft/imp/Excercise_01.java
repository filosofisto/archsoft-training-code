package com.archsoft.imp;

import com.archsoft.Exercise;

import java.util.stream.IntStream;

import static com.archsoft.Console.*;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_01 extends Exercise {

	private static final String DESCRIPTION =
			"Construa um programa que leia do console 3 números inteiros, " +
			"e imprima o resultado em ordem crescente";
	
	public Excercise_01() {
		super(DESCRIPTION);
	}

	@Override
	protected void doRun() {
		int a = readInt("Digite o primeiro número:");
		int b = readInt("Digite o segundo número:");
		int c = readInt("Digite o terceiro número:");

		println("Solução: ");
		
		IntStream.of(a, b, c).sorted().forEach(n -> print(n + " "));
	}
}
