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

            Message m1 = new Message();
            m1.setText("Texto Message 1");
            entityManager.persist(m1);

            Message m2 = new Message();
            m2.setText("Texto Message 2");
            m2.setNextMessage(m1);

            entityManager.persist(m2);

            // if (true) throw new RuntimeException("Simula Erro");

            Query query = entityManager
                    .createQuery("select m from Message m order by text");
            List<Message> resultList = query.getResultList();

            out.println("Lista de Mensagens");
            out.println("------------------");
            resultList.forEach(out::println);

			/*Message x = new Message();
			x.setId(7L);

			x = entityManager.merge(x);

			x.setText("Bingo");*/

            Message m = entityManager.find(Message.class, 1L);
            out.println(m.getText());
            m.setText(m.getText() + "***");

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
