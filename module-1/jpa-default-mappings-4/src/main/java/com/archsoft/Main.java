package com.archsoft;

import com.archsoft.model.Address;
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

//            Address address = new Address();
//            address.setStreet("Av Paulista");
//            entityManager.persist(address);
//
//            Employee e1 = new Employee();
//            e1.setAddress(address);
//            entityManager.persist(e1);
//
//            Employee e2 = new Employee();
//            e2.setAddress(address);
//            entityManager.persist(e2);

            Employee e = entityManager.find(Employee.class, 102L);
//            System.out.printf("Employee id: %d\n", e.getId());
            System.out.printf("Address id: %s\n", e.getAddress().getStreet());

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}
