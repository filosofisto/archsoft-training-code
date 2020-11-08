package com.archsoft.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class ShoppingCart extends Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_shopping_cart")
    private Long id;

    @OneToMany
    private Collection<Item> items = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addItem(Item item) {
        items.add(item);
        incrementOperationCount();
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
}
