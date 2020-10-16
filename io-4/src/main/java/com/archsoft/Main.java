package com.archsoft;

import java.io.*;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		try {
			File file = new File("project.obj");
			ProjectPersister projectPersister = new ProjectPersister();
			ProjectBuilder projectBuilder = new ProjectBuilder();

			if (!file.exists()) {
				Project project = projectBuilder.build();
				projectPersister.save(project, file);
			}
			
			Project projectLoadedFromFile = projectPersister.load(file);
			
			out.println(projectLoadedFromFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
