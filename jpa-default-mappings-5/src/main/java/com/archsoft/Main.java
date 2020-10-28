package com.archsoft;

import com.archsoft.model.Project;
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

            Project p1 = new Project();
            entityManager.persist(p1);

            Project p2 = new Project();
            entityManager.persist(p2);

            Employee e1 = new Employee();
            entityManager.persist(e1);

            Employee e2 = new Employee();
            entityManager.persist(e2);

            p1.getEmployees().add(e1);
            p1.getEmployees().add(e2);

            p2.getEmployees().add(e1);
            p2.getEmployees().add(e2);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}
