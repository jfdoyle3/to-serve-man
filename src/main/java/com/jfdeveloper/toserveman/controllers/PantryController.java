package com.jfdeveloper.toserveman.controllers;

import com.jfdeveloper.toserveman.entities.Pantry;
import com.jfdeveloper.toserveman.entities.Recipe;
import com.jfdeveloper.toserveman.repositories.PantryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pantry")
public class PantryController {

    @Autowired
    PantryRepository repository;

    @GetMapping("/")
    @ResponseBody
    public List<Pantry> getAllPantry() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Pantry> createRecipe(@RequestBody Pantry newPantry) {
        return new ResponseEntity<>(repository.save(newPantry), HttpStatus.CREATED);
    }
}