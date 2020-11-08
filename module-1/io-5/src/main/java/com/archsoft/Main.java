package com.archsoft;

public class Main {

	public static void main(String[] args) {
		Keyboard keyboard = new Keyboard();
		keyboard.registerCommand("dir", new DirCommand());
		keyboard.registerCommand("type", new TypeCommand());
		keyboard.start();
	}
}
