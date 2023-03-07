package com.jfdeveloper.toserveman.repositories;

import com.jfdeveloper.toserveman.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {

    List<Recipe> findByTitleContaining(String title);
}
