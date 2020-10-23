package com.archsoft.imp;

import com.archsoft.Exercise;

import static com.archsoft.Console.print;
import static com.archsoft.Console.println;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_16 extends Exercise {

	private static final String DESCRIPTION =
			"Faça um programa que popule um array de 100 posições "
			+ "com valores aleatórios entre 1 e 100, pesquise um número (definido também aleatoriamente) "
			+ "dentro do array e caso encontre o número desejado, imprima a posição "
			+ "que o mesmo se encontra ou informe que o mesmo náo existe. Exiba também "
			+ "o tempo de processamento em milissegundos";
	
	public Excercise_16() {
		super(DESCRIPTION);
	}
	
	private static int nextNumber() {
		return 1 + RANDOMIZER.nextInt(100);
	}

	@Override
	protected void doRun() {
		long start = System.currentTimeMillis();
		
		int[] array = new int[100];
		for(int i = 0; i < array.length; i++) {
			print((array[i] = nextNumber()) + " ");
		}
		println();

		int number = nextNumber();
		int i = 0;
		while(i < array.length && array[i] != number) {
			i++;
		}
		
		print("número " + number);
		if (i == array.length) {
			println(" não existe");
		} else {
			println(" existe no índice " + i);
		}
		
		long time = System.currentTimeMillis() - start;
		println("O tempo foi: " + time + " milisegundos");
	}
}
