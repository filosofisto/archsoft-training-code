package com.archsoft;

public class Pessoa {

    public Pessoa() {

    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    private String nome;

    private int idade;

    private int sexo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade >= 0 && idade < 150) {
            this.idade = idade;
        }
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Pessoa)) return false;
        if (this == obj) return true;

        Pessoa other = (Pessoa) obj;

        boolean nomeEquals = (nome == null && other.getNome() == null)
                || nome.equals(other.getNome());

        return nomeEquals && idade == other.getIdade() && sexo == other.getSexo();
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade;
    }
}
