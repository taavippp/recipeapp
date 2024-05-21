package com.taavippp.recipeapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

    // broken
    @Column(name = "ingredients", nullable = false)
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients;
}
