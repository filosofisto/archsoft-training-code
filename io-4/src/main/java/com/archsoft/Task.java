package com.archsoft;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {

    private static final long serialVersionUID = 7292408037891070511L;

    private int id;
    private String description;
    private Date data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return getId() + "-" + getDescription();
    }

}
