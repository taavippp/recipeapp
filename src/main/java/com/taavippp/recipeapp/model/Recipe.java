package com.taavippp.recipeapp.model;

import com.taavippp.recipeapp.util.IngredientConverter;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "recipes")
@Getter
@Builder @NoArgsConstructor @AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ingredient", nullable = false)
    @Convert(converter = IngredientConverter.class)
    private Ingredient ingredient;
}
