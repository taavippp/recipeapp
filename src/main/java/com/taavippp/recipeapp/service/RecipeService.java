package com.taavippp.recipeapp.service;

import com.taavippp.recipeapp.model.Ingredient;
import com.taavippp.recipeapp.model.MeasurementUnit;
import com.taavippp.recipeapp.model.Recipe;
import com.taavippp.recipeapp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public void create(String name) {
        Recipe recipe = Recipe
                .builder()
                .name(name)
                .ingredient(new Ingredient(50, MeasurementUnit.GRAM, "cheese"))
                .build();
        recipeRepository.saveAndFlush(recipe);
    }

    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }
}
