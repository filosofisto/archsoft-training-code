package com.archsoft;

import com.archsoft.model.AnnualReview;
import com.archsoft.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-01");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            AnnualReview ar1 = new AnnualReview();
            entityManager.persist(ar1);

            AnnualReview ar2 = new AnnualReview();
            entityManager.persist(ar2);

            Employee e1 = new Employee();
            e1.getAnnualReviews().add(ar1);
            e1.getAnnualReviews().add(ar2);
            entityManager.persist(e1);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}
