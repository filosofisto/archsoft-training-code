package com.archsoft;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Project implements Serializable {

    private static final long serialVersionUID = 7557299738287248337L;

    private Person manager;
    private List<Task> tasks;
    //private Equipe equipe;
    private transient String bla;
    private String novoAttr;
    private int novoInt;

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }

    public List<Task> getTarefas() {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }

        return tasks;
    }

    public void setTarefas(List<Task> tasks) {
        this.tasks = tasks;
    }
	/*public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}*/

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("Gerente: " + getManager() + "\n");
        b.append("Tarefas\n");

        for (Task t : getTarefas()) {
            b.append("\t" + t + "\n");
        }

        //b.append(getEquipe());

        return b.toString();
    }

    public String getNovoAttr() {
        return novoAttr;
    }

    public void setNovoAttr(String novoAttr) {
        this.novoAttr = novoAttr;
    }

    public int getNovoInt() {
        return novoInt;
    }

    public void setNovoInt(int novoInt) {
        this.novoInt = novoInt;
    }


}
