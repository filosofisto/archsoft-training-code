package com.archsoft;

import com.archsoft.model.Department;
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

            Employee e1 = new Employee();
            entityManager.persist(e1);

            Employee e2 = new Employee();
            entityManager.persist(e2);

            Department department = new Department();
            department.addEmployee(e1);
            department.addEmployee(e2);
            entityManager.persist(department);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}
