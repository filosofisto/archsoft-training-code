package com.archsoft;

public class Main {

    public static void main(String[] args) {
        Pessoa p = new Pessoa("Francisco", 77);
        Pessoa pele = new Pessoa();
        pele.setNome("Pele");
        pele.setIdade(80);

//        p.setNome("Francisco");
//        p.setIdade(77);
        //p.idade = -1;

//        System.out.printf("Nome: %s, Idade: %d", p.getNome(), p.getIdade());
        System.out.println("Pessoa: " + p);

        Funcionario f = new Funcionario();
        f.setMatricula("1234");
        f.setSalario(25000.0);
        f.setNome("Maradona");
        f.setIdade(67);

        System.out.println("Funcionario: " + f);
    }
}
