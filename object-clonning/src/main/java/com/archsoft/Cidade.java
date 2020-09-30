package com.archsoft;

public class Cidade implements Cloneable {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade clone() throws CloneNotSupportedException {
        Cidade clone = (Cidade) super.clone();
        clone.setNome(new String(nome));

        return clone;
    }
}
