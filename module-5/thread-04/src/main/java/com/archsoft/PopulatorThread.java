package com.archsoft;

import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class PopulatorThread extends Thread {
	
	private List<Integer> list;
	
	public PopulatorThread(String name, List<Integer> list) {
		super(name);
		this.list = list;
	}

	public void run() {
		out.printf("%s started\n", getName());
		
		Random rnd = new Random();
		int value;
		for (int i = 0; i < 100; i++) {
			value = rnd.nextInt(1000);
			list.add(value);
			out.printf("\tAdicionado item %d\n", value);

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		out.printf("%s finished\n", getName());
	}
}
