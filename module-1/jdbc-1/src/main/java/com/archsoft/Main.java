package com.archsoft;

import java.sql.Connection;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        try(Connection connection = Connector.connect(); PessoaDAO dao = new PessoaDAO(connection)) {
            Pessoa p = new Pessoa();

            p.setCpf("81646674987");
            p.setNome("Eduardo");
            p.setIdade(49);

            // Create
            dao.create(p);
            out.println("Registro incluido com sucesso");

            // Update
            p.setIdade(25);
            dao.update(p);
            out.println("Registro atualizado com sucesso");

            // Read
            Pessoa edu = dao.read("81646674987");
            out.println(edu);

            // Delete
            dao.delete("81646674987");
            out.println("Registro excluido com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
