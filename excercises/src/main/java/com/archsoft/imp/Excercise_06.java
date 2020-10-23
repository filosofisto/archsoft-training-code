package com.archsoft.imp;

import com.archsoft.Exercise;

import static com.archsoft.Console.println;
import static com.archsoft.Console.readInt;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_06 extends Exercise {

	private static final String DESCRIPTION =
			"Elaborar um programa que lê 2 números e imprime a " +
			"mensagem: \"São múltiplos\" ou \"Não são múltiplos";
	
	public Excercise_06() {
		super(DESCRIPTION);
	}

	@Override
	protected void doRun() {
		int n1 = readInt("Digite o primeiro número: ");
		int n2 = readInt("Digite o segundo número: ");
		
		String msg = n1 % n2 != 0 && n2 % n1 != 0 ? "não " : "";
		
		println(msg + "são múltiplos");
	}
}
