package com.jfdeveloper.toserveman.entities;

import javax.persistence.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public Ingredient getIngredient() {
        return ingredient;
    }


}
