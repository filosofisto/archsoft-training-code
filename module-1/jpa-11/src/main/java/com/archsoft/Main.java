package com.archsoft;

import com.archsoft.entity.Item;
import com.archsoft.entity.Product;
import com.archsoft.entity.ShoppingCart;

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

            Product p1 = new Product();
            p1.setName("Ball");
            p1.setPrice(1.5f);
            entityManager.persist(p1);

            Product p2 = new Product();
            p1.setName("Pencil");
            p1.setPrice(12.1f);
            entityManager.persist(p2);

            ShoppingCart shoppingCart = new ShoppingCart();

            Item i1 = new Item();
            i1.setQuantity(2);
            i1.setProduct(p1);
            entityManager.persist(i1);

            Item i2 = new Item();
            i2.setQuantity(1);
            i2.setProduct(p2);
            entityManager.persist(i2);

            shoppingCart.addItem(i1);
            shoppingCart.addItem(i2);

            entityManager.persist(shoppingCart);

			transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
