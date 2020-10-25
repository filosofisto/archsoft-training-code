package com.archsoft;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-01");
        EntityManager entityManager = factory.createEntityManager();

        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void showMessages(String header, List<Message> messages) {
        out.println("----------------------------------------");
        out.println(header);
        out.println("----------------------------------------");
        messages.stream().forEach(out::println);
    }
}
