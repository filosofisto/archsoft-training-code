package com.archsoft;

import com.archsoft.entity.Endereco;
import com.archsoft.entity.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-01");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Pessoa p = new Pessoa();
            p.setNome("Jose da Silva");

            Endereco e = new Endereco();
            e.setRua("Araucaria");
            e.setCidade("Brasilia");
            e.setEstado("DF");
            e.setCep("88000000");

            entityManager.persist(e);

            p.setEndereco(e);

            entityManager.persist(p);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try {
            transaction.begin();
            Pessoa p = entityManager.find(Pessoa.class, 1L);
            entityManager.remove(p);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
