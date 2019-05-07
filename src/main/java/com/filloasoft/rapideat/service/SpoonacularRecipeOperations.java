package com.filloasoft.rapideat.service;

import com.filloasoft.rapideat.model.entity.SpoonacularRecipe;
import java.io.IOException;
import java.util.List;

public interface SpoonacularRecipeOperations {

    public SpoonacularRecipe getRecipe(String recipeID) throws IOException;

    public List<SpoonacularRecipe> getRecipesByIngredients(String ingredientsKeywords, int numResults) throws IOException;

    public List<SpoonacularRecipe> getRandomRecipes(String number, String tags) throws IOException;

}
