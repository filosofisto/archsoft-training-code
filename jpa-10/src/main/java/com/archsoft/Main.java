package com.archsoft;

import com.archsoft.entity.Address;
import com.archsoft.entity.FullTimeEmployee;
import com.archsoft.entity.PartialTimeEmployee;

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

			Address address = new Address();
			entityManager.persist(address);

			FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
			fullTimeEmployee.setAddress(address);
			fullTimeEmployee.setSalary(20000.0);
			entityManager.persist(fullTimeEmployee);

			PartialTimeEmployee partialTimeEmployee = new PartialTimeEmployee();
			partialTimeEmployee.setAddress(address);
			partialTimeEmployee.setHourlyWage(190f);
			entityManager.persist(partialTimeEmployee);

			transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
