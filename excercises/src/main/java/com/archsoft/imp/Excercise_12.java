package com.archsoft.imp;

import com.archsoft.Exercise;

import static com.archsoft.Console.println;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_12 extends Exercise {

	private static final String DESCRIPTION =
			"Escreva um programa que calcule o valor de H, sendo que ele é " +
			"determinado pela série H = 1/1 + 3/2 + 5/3 + 7/4 + ... + 99/50";
	
	public Excercise_12() {
		super(DESCRIPTION);
	}

	@Override
	protected void doRun() {
		double h = 0;
		for(double n = 1, d = 1; n <= 99 && d <= 50; n += 2, d++) {
			h += (n / d);
		}
		println("Solução H = " + h);
	}
}
