package com.archsoft;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Project implements Serializable {

    private static final long serialVersionUID = 7557299738287248337L;

    private Person manager;
    private List<Task> tasks;
    private Team team;

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }

    public List<Task> getTasks() {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }

        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("Manager: " + getManager() + "\n");
        b.append("Tasks\n");

        for (Task t : getTasks()) {
            b.append("\t" + t + "\n");
        }

        b.append(getTeam());

        return b.toString();
    }



}
