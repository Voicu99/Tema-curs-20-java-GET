package com.tema.temacurs20finalv2.controllers;

import com.tema.temacurs20finalv2.models.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeController {

    @GetMapping("/search")
    public String searchRecipes(@RequestParam("ingredients") String ingredients,
                                @RequestParam("dishType") String dishType) {
        // Simulated recipe data
        List<Recipe> allRecipes = new ArrayList<>();
        allRecipes.add(new Recipe("Pasta Primavera", List.of("pasta", "vegetables"), "Boil pasta and sauté vegetables."));
        allRecipes.add(new Recipe("Chocolate Cake", List.of("flour", "sugar", "cocoa"), "Mix ingredients and bake."));

        // Search for recipes matching the ingredients
        List<Recipe> matchedRecipes = new ArrayList<>();
        for (Recipe recipe : allRecipes) {
            if (recipe.getIngredients().stream().anyMatch(ingredient -> ingredients.contains(ingredient))) {
                matchedRecipes.add(recipe);
            }
        }

        // Build a response string
        StringBuilder response = new StringBuilder("Matched Recipes: \n");
        for (Recipe recipe : matchedRecipes) {
            response.append("Title: ").append(recipe.getTitle())
                    .append(", Instructions: ").append(recipe.getInstructions()).append("\n");
        }
        return response.toString();
    }
}




