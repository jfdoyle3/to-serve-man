package com.jfdeveloper.toserveman.repositories;

import com.jfdeveloper.toserveman.entities.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, String> {

    List<Recipe> findByTitleContaining(String title);
}
