package com.archsoft;

import java.util.Random;

import static com.archsoft.Console.println;

public abstract class Exercise implements Runnable {

	protected static final Random RANDOMIZER = new Random(System.currentTimeMillis());
	
	private String description;

	public Exercise(String description) {
		this.description = description;
	}
	
	protected void begin() {
		println("================================================");
		println(": " + getClass().getSimpleName());
		println(": " + description);
		println("================================================");
	}

	@Override
	public void run() {
		try {
			begin();
			doRun();
		} catch(Exception e) {
			handleException(e);
		} finally {
			end();
		}
	}

	protected void end() {
		println();
	}

	protected void handleException(Exception e) {
		println(e.getMessage());
	}
	
	protected abstract void doRun();
}
