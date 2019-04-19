package com.filloasoft.rapideat.recipeservice;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RestController;

import com.filloasoft.rapideat.recipe.Recipe;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
public class RecipeController {
	
    @Autowired
    RecipeService recipeService;
    
    @GetMapping("/recipe/{id}")
	public Recipe getRecipe(@PathVariable String id) throws UnirestException, IOException {
		return recipeService.getRecipe(id);
	}


}
