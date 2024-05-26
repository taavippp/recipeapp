package com.taavippp.recipeapp.controller;

import com.taavippp.recipeapp.model.Recipe;
import com.taavippp.recipeapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<Recipe>> getRecipes() {
        List<Recipe> recipes = recipeService.getAll();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createRecipe(
            @RequestBody Recipe recipe
    ) {
        recipeService.create(recipe);
        return new ResponseEntity<>("Recipe created", HttpStatus.OK);
    }
}
