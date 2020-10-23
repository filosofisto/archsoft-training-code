package com.archsoft.imp;

import com.archsoft.Console;
import com.archsoft.Exercise;

import static com.archsoft.Console.println;

/**
 * @author Leonardo de Lima Oliveira
 */
public class Excercise_19 extends Exercise {

	private static final String DESCRIPTION = "Construa um programa que crie 2 matrizes "
			+ "de ordem 3 (3 linhas e 3 colunas), a partir de valores inteiros aleatórios "
			+ "entre 0 e 100 e imprima no console a soma e subtração das mesmas";
	

	@FunctionalInterface
	protected static interface Consumer {
		void accept(int i, int j, int[][] m);
	}

	protected static class Matrix {
		private int[][] m = new int[3][3];
		
		Matrix() {
			init((i, j, m) -> m[i][j] = 0);
		}
		
		Matrix(Consumer c) {
			init(c);
		}
		
		private void init(Consumer c) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					c.accept(i, j, m);
				}
			}
		}
		
		public Matrix add(Matrix p) {
			return new Matrix((i, j, m) -> m[i][j] = this.m[i][j] + p.m[i][j]);
		}

		public Matrix sub(Matrix p) {
			return new Matrix((i, j, m) -> m[i][j] = this.m[i][j] - p.m[i][j]);
		}

		public void print() {
			init((i, j, m) -> {
				Console.print(m[i][j] + " ");
				if (j == 2) {
					println();
				}
			});
		}
	}
	
	public Excercise_19() {
		super(DESCRIPTION);
	}
	
	@Override
	protected void doRun() {
		Matrix m1 = new Matrix((i, j, m) -> m[i][j] = RANDOMIZER.nextInt(101));
		Matrix m2 = new Matrix((i, j, m) -> m[i][j] = RANDOMIZER.nextInt(101));
		println("===========================");
		println("* Matrix 1");
		println("===========================");
		m1.print();
		
		println("===========================");
		println("* Matrix 2");
		println("===========================");
		m2.print();
		
		println("===========================");
		println("* m1 + m2");
		println("===========================");
		
		m1.add(m2).print();
		
		println("===========================");
		println("* m1 - m2");
		println("===========================");
		
		m1.sub(m2).print();
	}
}


