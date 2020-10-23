package com.archsoft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public final class Console {
	
	private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()));
	
	private Console() {}

	public static void print(String message) {
		System.out.print(message);
	}

	public static void println(Object message) {
		System.out.println(message);
	}

	public static void println() {
		System.out.println();
	}

	public static int readInt(String message) {
		do {
			try {
				print(message);
				return Integer.parseInt(READER.readLine());
			}catch(Exception e) {
				println("inválido");
			}
		}while(true);
	}
	
	public static double readDouble(String message) {
		do {
			try {
				print(message);
				return Double.parseDouble(READER.readLine());
			}catch(Exception e) {
				println("inválido");
			}
		}while(true);
	}

	public static float readFloat(String message) {
		do {
			try {
				print(message);
				return Float.parseFloat(READER.readLine());
			}catch(Exception e) {
				println("inválido");
			}
		}while(true);
	}


	public static String readString(String message) {
		do {
			try {
				print(message);
				String line = READER.readLine();
				return line != null ? line : "";
			}catch(Exception e) {
				println("inválido");
			}
		}while(true);
	}
}
