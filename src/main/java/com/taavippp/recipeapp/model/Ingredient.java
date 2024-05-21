package com.taavippp.recipeapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "ingredients")
@Getter
@Builder @NoArgsConstructor @AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "unit", nullable = false)
    private MeasurementUnit unit;

    @Column(name = "name", nullable = false)
    private String name;

    // broken
    @JoinColumn(name = "recipe_id", nullable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Recipe recipe;
}
