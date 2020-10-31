package com.archsoft;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-01");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            Message m1 = new Message();
//            m1.setText("M1");
//            entityManager.persist(m1);
//
//            Message m2 = new Message();
//            m2.setText("M2");
//            m2.setNextMessage(m1);
//            entityManager.persist(m2);
//
//            Message m3 = new Message();
//            m3.setText("M3");
//            m3.setNextMessage(m1);
//            entityManager.persist(m3);

            showMessages(
                    "Lista de Mensagens",
                    entityManager.createNamedQuery("messages", Message.class).getResultList()
            );

            showMessages(
                    "Lista de Mensagens Sem NextMessage",
                    entityManager.createNamedQuery("messagesNoNext", Message.class).getResultList()
            );

            showMessages(
                    "Lista de Mensagens NextMessage=1",
                    entityManager.createNamedQuery("messagesByNext", Message.class)
                            .setParameter("nextMessageId", 1L)
                            .getResultList()
            );

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    private static void showMessages(String header, List<Message> messages) {
        out.println("----------------------------------------");
        out.println(header);
        out.println("----------------------------------------");
        messages.forEach(out::println);
    }
}
