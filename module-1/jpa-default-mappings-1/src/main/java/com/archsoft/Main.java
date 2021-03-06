package com.archsoft;

import com.archsoft.model.Cubicle;
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

            Cubicle cubicle = new Cubicle();

            Employee employee = new Employee();
            employee.setAssignedCubicle(cubicle);
            cubicle.setResidentEmployee(employee);

            entityManager.persist(cubicle);
            entityManager.persist(employee);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();
        }

//        try {
//            Cubicle cubicle = entityManager.find(Cubicle.class, 1L);
//
//            System.out.printf("Employee Id: %d\n", cubicle.getResidentEmployee().getId());
//        } catch (Exception e) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//
//            e.printStackTrace();
//        }
    }
}
