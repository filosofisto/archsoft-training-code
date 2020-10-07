package com.archsoft;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File file = new File("generated.dat");

		DataProducer dataProducer = new DataProducer();
		DataConsumer dataConsumer = new DataConsumer();

		try {
			dataProducer
					.into(file)
					.prepare()
					.produce(100)
					.close();

			dataConsumer
				.from(file)
				.prepare()
				.read()
				.close();

			System.out.printf("Count: %d, Total: %d\n", dataConsumer.getCount(), dataConsumer.getTotal());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
