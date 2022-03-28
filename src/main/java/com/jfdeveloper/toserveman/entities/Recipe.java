package com.jfdeveloper.toserveman.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="recipes")
public class Recipe {

    @Id
    private String id;
    private String title;
    private String ingredients;
    private String directions;

    public Recipe() {
    }

    public Recipe(String title, String ingredients, String directions) {
        this.title = title;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
}
