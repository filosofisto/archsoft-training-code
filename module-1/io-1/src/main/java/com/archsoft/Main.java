package com.archsoft;

import java.io.File;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		String dirName = ajustarSepadador(System.getProperty("user.home"));

		File dir = new File(dirName);
		
		for (File f: dir.listFiles()) {
			if (f.isDirectory()) {
				out.println("[folder] " + f.getAbsolutePath());
			} else {
				out.printf("[file]   %s - %d bytes\n",
						f.getAbsolutePath(),
						f.length());
			}
		}
	}
	
	private static String ajustarSepadador(
			String texto) {
		return texto
				.replace("/", File.separator)
				.replace("\\", File.separator);
	}
}
