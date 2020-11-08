package com.archsoft;

import javax.persistence.*;
import java.util.List;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-01");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            1
//            Message m1 = new Message();
//            m1.setText("Texto Message 1");
//            entityManager.persist(m1);

//            2
//            m1.setText("Texto Message 1 (changed)");

//            3
            Message m1 = new Message();
            m1.setId(1L);
            m1.setText("Texto Message 1 (merged)");
            entityManager.merge(m1);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
