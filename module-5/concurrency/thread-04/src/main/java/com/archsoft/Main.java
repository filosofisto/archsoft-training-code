package com.archsoft;

import java.util.ArrayList;
import java.util.List;


/**
 * Sincronizando Threads com join.
 */
public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		PopulatorThread populatorThread = new PopulatorThread("Populator", list);
		SortThread sortThread = new SortThread("Sorter", list, populatorThread);
		SearchThread search = new SearchThread("Searcher", list, sortThread);

		// Relacao de dependencia
		// SearchThread -> SortThread -> PopulatorThread

		search.start();
		sortThread.start();
		populatorThread.start();
	}
}
