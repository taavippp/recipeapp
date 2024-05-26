package com.taavippp.recipeapp.service;

import com.taavippp.recipeapp.model.Ingredient;
import com.taavippp.recipeapp.model.MeasurementUnit;
import com.taavippp.recipeapp.model.Recipe;
import com.taavippp.recipeapp.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    private static Logger logger = LoggerFactory.getLogger(RecipeService.class);

    public void create(Recipe recipe) {
        // This sets up the DB relationship between the recipe and its ingredients
        for (Ingredient i : recipe.getIngredients()) {
            i.setRecipe(recipe);
        }
        recipeRepository.saveAndFlush(recipe);
    }

    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }
}
