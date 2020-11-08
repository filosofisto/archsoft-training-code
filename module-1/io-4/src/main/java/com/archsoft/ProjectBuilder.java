package com.archsoft;

public class ProjectBuilder {

    public Project build() {
        Project project = new Project();

        Person manager = new Person();
        manager.setName("Bill Gates");
        project.setManager(manager);

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

        project.setTeam(team);

        Task t1 = new Task();
        t1.setId(1);
        t1.setDescription("Analise de Requisito");
        project.getTasks().add(t1);
        Task t2 = new Task();
        t2.setId(2);
        t2.setDescription("Projeto");
        project.getTasks().add(t2);

        return project;
    }
}
