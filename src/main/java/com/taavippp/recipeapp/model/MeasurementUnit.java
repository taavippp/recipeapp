package com.taavippp.recipeapp.model;

public enum MeasurementUnit {
    GRAM("g"),
    KILOGRAM("kg"),
    MILLILITER("ml"),
    LITER("l"),
    TEASPOON("tsp"),
    TABLESPOON("tbsp"),
    CUP("c"),
    PINT("pt"),
    QUART("qt"),
    GALLON("gal"),
    OUNCE("oz"),
    FLUID_OUNCE("fl oz"),
    POUND("lb");

    public final String abbreviation;

    MeasurementUnit(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
