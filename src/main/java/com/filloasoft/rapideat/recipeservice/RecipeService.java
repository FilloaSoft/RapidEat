package com.filloasoft.rapideat.recipeservice;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.filloasoft.rapideat.recipe.Recipe;


@Service
public interface RecipeService {

	public Recipe getRecipe(String recipeID) throws IOException;
	public List<Recipe> getRecipesByIngredients(String ingredientsKeywords, int numResults) throws IOException;

}