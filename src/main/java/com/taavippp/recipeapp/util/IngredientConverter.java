package com.taavippp.recipeapp.util;

import com.taavippp.recipeapp.model.Ingredient;
import com.taavippp.recipeapp.model.MeasurementUnit;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class IngredientConverter implements AttributeConverter<Ingredient, String> {
    @Override
    public String convertToDatabaseColumn(Ingredient measurement) {
        return String.format(
                "%d %s %s",
                measurement.amount(),
                measurement.unit().abbreviation,
                measurement.name()
        );
    }

    @Override
    public Ingredient convertToEntityAttribute(String measurement) {
        String[] stringData = measurement.split(" ");
        if (stringData.length != 3) {
            return null;
        }

        String amountStr = stringData[0];
        String unitStr = stringData[1];
        String name = stringData[2];

        try {
            MeasurementUnit unit = null;

            for (MeasurementUnit mu : MeasurementUnit.values()) {
                if (mu.abbreviation.equals(unitStr)) {
                    unit = mu;
                }
            }

            return new Ingredient(
                    Integer.parseInt(amountStr),
                    unit,
                    name
            );
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
