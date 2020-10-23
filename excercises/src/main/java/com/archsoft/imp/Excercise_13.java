package com.archsoft.imp;

import com.archsoft.Exercise;

import static com.archsoft.Console.println;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_13 extends Exercise {

	private static final String DESCRIPTION =
			"Dado a série infinita X = 1 + 1/2 + 1/4 + ..., calcule o valor "
			+ "da série até atingir a precisão de 0,001. A precisão é "
			+ "alcançada quando a diferença entre uma iteração e outra "
			+ "é inferior a precisão desejada. Exiba o resultado da "
			+ "soma e a quantidade de iterações. Posteriormente aumenta "
			+ "a precisão para 0,000001 e compare o resultado";
	
	public Excercise_13() {
		super(DESCRIPTION);
	}

	@Override
	protected void doRun() {
		int time = 0;
		double precision = 0.001;
		
		do {
			double x = 0;
			int iteration = 0;
			
			for(double d = 1; ; d += 2) {
				double previous = x;
				x += (1d/d);
				if (x - previous < precision) {
					break;
				}
				iteration++;
			}
			
			println("Precisão " + precision + " X = " + x + " iterações: " + iteration);
			precision = 0.000001d;
		}while(++time <= 1);
	}
}
