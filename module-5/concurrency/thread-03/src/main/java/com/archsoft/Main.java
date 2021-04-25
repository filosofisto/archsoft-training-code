package com.archsoft;


/**
 * Exemplo utilizando threads em paralelas, mas utilizando
 * a interface Runnable.
 * 
 * @author eduardo
 *
 */
public class Main {

	public static void main(String[] args) {
		Thread[] threads = new Thread[10];
		
		//Constroi as runnables e threads
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new MyRunnable());
		}
		
		//Starta as threads
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}
}
