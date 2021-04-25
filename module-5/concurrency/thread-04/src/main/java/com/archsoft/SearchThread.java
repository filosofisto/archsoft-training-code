package com.archsoft;

import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class SearchThread extends Thread {

	private List<Integer> list;
	private SortThread sortThread;
	
	public SearchThread(String name, List<Integer> list, SortThread sortThread) {
		super(name);
		this.list = list;
		this.sortThread = sortThread;
	}
	
	public void run() {
		try {
			out.printf("%s started\n", getName());
			out.println("Waiting sort the list");
			sortThread.join();
			out.println("List sorted, starting my work");

			Random random = new Random();
			Integer searchFor = random.nextInt(1000);
			Integer item;

			for (int i = 0; i < list.size(); i++) {
				item = list.get(i);
				out.printf("\tSearching...current value: %d\n", item);
				if (item.equals(searchFor)) {
					out.printf("Found at %d\n", i);
					break;
				} else {
					if (item > searchFor) {
						out.printf("\tItem %d not found\n", searchFor);
						break;
					}
				}
			}
			
			out.printf("%s - finished\n", getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
