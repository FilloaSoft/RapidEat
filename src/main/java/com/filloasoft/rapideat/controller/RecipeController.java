package com.filloasoft.rapideat.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filloasoft.rapideat.model.entity.SpoonacularRecipe;
import com.filloasoft.rapideat.service.SpoonacularRecipeService;

@RestController
public class RecipeController {

    @Autowired
    SpoonacularRecipeService recipeService;

    @GetMapping("/recipe/{id}")
    public SpoonacularRecipe getRecipe(@PathVariable String id) throws IOException {
        return recipeService.getRecipe(id);
    }

    //exemplo de petición: http://localhost:8085/recipe/search?ingredients=tomato%chicken%onion
    @GetMapping("/recipe/search")
    public List<SpoonacularRecipe> getRecipeByIngredients(@RequestParam String ingredients) throws IOException {
        return recipeService.getRecipesByIngredients(ingredients, 5);
    }

    //(calquer tipo) http://localhost:8085/recipe/random?tags
    //(Random filtradas) http://localhost:8085/recipe/random?tags=vegetarian%burger
    @GetMapping("/recipe/random")
    public List<SpoonacularRecipe> getRandomRecipes(@RequestParam(required = false) String tags) throws IOException {
        return recipeService.getRandomRecipes(Integer.toString(10), tags);
    }

}
