package com.archsoft;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		try {
			File file = new File("project.obj");
			
			if (!file.exists()) {
				persistProject(file);
			}
			
			Project p = loadProject(file);
			
			System.out.println(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void persistProject(File file) throws IOException,
			FileNotFoundException {
		Project p = buildProject();
		
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(file));
		out.writeObject(p);
		out.close();
	}

	private static Project buildProject() {
		Project p = new Project();
		
		Person gerente = new Person();
		gerente.setName("Bill Gates");
		p.setManager(gerente);
		
		Team team = new Team();
		Person m1 = new Person();
		m1.setName("Eduardo");
		team.getMembers().add(m1);
		Person m2 = new Person();
		m2.setName("Renato");
		team.getMembers().add(m2);
		Person m3 = new Person();
		m3.setName("Filipe");
		team.getMembers().add(m3);
		Person m4 = new Person();
		m4.setName("Rubens");
		team.getMembers().add(m4);
		Person m5 = new Person();
		m5.setName("Rodrigo");
		team.getMembers().add(m5);

		//p.setEquipe(equipe);
		
		Task t1 = new Task();
		t1.setId(1);
		t1.setDescription("Analise de Requisito");
		p.getTarefas().add(t1);
		Task t2 = new Task();
		t2.setId(2);
		t2.setDescription("Projeto");
		p.getTarefas().add(t2);
		
		return p;
	}

	private static Project loadProject(File file) throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(file));
		Project ret = (Project) in.readObject();
		in.close();
		
		return ret;
	}
}
