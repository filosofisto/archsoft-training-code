package com.archsoft;


public class Main {

	public static void main(String[] args) {
		/*int x = 3 / 0;
		System.out.printf("x = %d", x);*/

		try {
			int x = 3 / 1;
			System.out.printf("x = %d\n", x);
			
			int[] array = new int[10];
			array[5] = 1;
		} catch (ArithmeticException e) {
			System.out.println("Nao sei dividir por ZERO, vc sabe?");
		} catch (Exception e) {
			System.out.println("Erro de array: " + e.getMessage());
		} finally {
			System.out.println("Bye;)");
		}
	}
}
