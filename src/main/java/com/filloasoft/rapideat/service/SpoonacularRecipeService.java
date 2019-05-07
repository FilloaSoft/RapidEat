package com.filloasoft.rapideat.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.filloasoft.rapideat.model.entity.SpoonacularRecipe;

@Service
public interface SpoonacularRecipeService {

    public SpoonacularRecipe getRecipe(String recipeID) throws IOException;

    public List<SpoonacularRecipe> getRecipesByIngredients(String ingredientsKeywords, int numResults) throws IOException;

    public List<SpoonacularRecipe> getRandomRecipes(String number, String tags) throws IOException;

}
