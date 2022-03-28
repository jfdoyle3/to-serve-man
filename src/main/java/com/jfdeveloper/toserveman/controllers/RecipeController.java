package com.jfdeveloper.toserveman.controllers;


import com.jfdeveloper.toserveman.entities.Recipe;
import com.jfdeveloper.toserveman.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RecipeController {

    @Autowired
    private RecipeRepository repository;

    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> getAllRecipes(@RequestParam String title){
        try{
            List<Recipe> recipes = new ArrayList<Recipe>();
            if(title==null)
                recipes.addAll(repository.findAll());
            else
                recipes.addAll(repository.findByTitleContaining(title));

            if(recipes.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(recipes,HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Recipe> createVehicle(@RequestBody Recipe newRecipe) {
        return new ResponseEntity<>(repository.save(newRecipe), HttpStatus.CREATED);
    }

    @PutMapping("/recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") String id,@RequestBody Recipe recipe){
        Optional<Recipe> recipeData=repository.findById(id);
        if(recipeData.isPresent()) {
            Recipe _recipe = recipeData.get();
            _recipe.setTitle(recipe.getTitle());
            _recipe.setIngredients(recipe.getIngredients());
            _recipe.setDirections(recipe.getDirections());
            return new ResponseEntity<>(repository.save(_recipe), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable("id")String id){
        try{
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/newBook")
    public ResponseEntity<HttpStatus> deleteAllRecipes(){
        try{
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
