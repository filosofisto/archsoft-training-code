package com.archsoft.imp;

import com.archsoft.Exercise;

import static com.archsoft.Console.println;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_14 extends Exercise {

	private static final String DESCRIPTION =
			"Calcule o famoso número PI através da série infinita " +
			"descoberta pelo grande matemático Leibniz, conforme " +
			"a formula Pi/4 = 1 - 1/3 + 1/5 - 1/7 + ... . Calcule com precisão 0,01 e depois " +
			"aumente a precisão para 0,0001";
	
	public Excercise_14() {
		super(DESCRIPTION);
	}

	@Override
	protected void doRun() {
		double precision = 0.01d;
		int times = 0;
		do {
			double pi_4 = 0;
			int sinal = 1;
			for(double d = 1; ; d += 2) {
				double previous = pi_4;
				pi_4 += sinal * (1d/d);
				if (Math.abs(pi_4 - previous) <= precision) {
					break;
				}
				sinal *= -1;
			}
			println("PI: " + (4d * pi_4) + " com precisão: " + precision);
			precision = 0.0001d;
		}while(++times <= 1);
	}
}
