package com.taavippp.recipeapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "ingredients")
@Getter
@Builder @NoArgsConstructor @AllArgsConstructor
public class Ingredient {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "unit", nullable = false)
    private MeasurementUnit unit;

    @Column(name = "name", nullable = false)
    private String name;

    @Setter
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Recipe recipe;
}
