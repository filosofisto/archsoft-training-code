package com.archsoft;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/**
 * Exemplo demonstrando utilizacao de threads paralelas.
 * 
 * @author eduardo
 *
 */
public class Main {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int n = 0; n < 3; n++) {
			executorService.execute(() -> {
				for (int i = 0; i < 3; i++) {
					out.printf("id: %d, valor do i=%d\n", Thread.currentThread().getId(), i);
					Thread.yield();
					/*if (i % 10 == 0) {
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}*/
				}
			});
		}

		// executor nao aceitara mais runnables (threads)
		// finalizara todas as threads da fila
		executorService.shutdown();

		try {
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Finished all threads");
	}
}
