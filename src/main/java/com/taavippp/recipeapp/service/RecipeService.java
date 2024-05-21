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

    public void create(String name) {
        Ingredient i1 = Ingredient
                .builder()
                .amount(40)
                .unit(MeasurementUnit.GALLON)
                .name("milk")
                .build();
        Ingredient i2 = Ingredient
                .builder()
                .amount(921)
                .unit(MeasurementUnit.GRAM)
                .name("flour")
                .build();
        Recipe recipe = Recipe
                .builder()
                .name(name)
                .ingredients(
                        Set.of(i1, i2)
                )
                .build();
        // i1.setRecipe(recipe);
        // i2.setRecipe(recipe);
        recipeRepository.saveAndFlush(recipe);
    }

    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }
}
