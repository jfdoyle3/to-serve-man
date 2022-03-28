package com.jfdeveloper.toserveman.controllers;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pantry {

    @Id
    private Long id;
    private String item;
    private int quantity;

    public Pantry() {}

    public Pantry(Long id, String item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
