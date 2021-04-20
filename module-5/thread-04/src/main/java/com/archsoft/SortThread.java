package com.archsoft;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

/**
 * Esta thread ordena a List<Number> para que outras Threads possam
 * fazer uma pesquisa binaria.
 * 
 * @author eduardo
 *
 */
public class SortThread extends Thread {
	
	private List<Integer> list;
	private PopulatorThread populatorThread;
	
	public SortThread(String name, List<Integer> list, PopulatorThread populatorThread) {
		super(name);
		this.list = list;
		this.populatorThread = populatorThread;
	}

	public void run() {
		try {
			out.printf("%s started\n", getName());

			out.println("Aguardando preenchimento da lista");
			populatorThread.join();
			out.println("Lista preenchida, iniciando meu trabalho");

			out.println("Sorting...");
			list.sort(Comparator.naturalOrder());

			out.printf("%s finished\n", getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
