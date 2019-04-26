package com.filloasoft.rapideat.recipeservice;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filloasoft.rapideat.recipe.OldRecipe;

@RestController
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/recipe/{id}")
    public OldRecipe getRecipe(@PathVariable String id) throws IOException {
        return recipeService.getRecipe(id);
    }

    //exemplo de petición: http://localhost:8085/recipe/search?ingredients=tomato%chicken%onion
    @GetMapping("/recipe/search")
    public List<OldRecipe> getRecipeByIngredients(@RequestParam String ingredients) throws IOException {
        return recipeService.getRecipesByIngredients(ingredients, 5);
    }

}
