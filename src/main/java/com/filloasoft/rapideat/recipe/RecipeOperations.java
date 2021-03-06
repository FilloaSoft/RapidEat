package com.filloasoft.rapideat.recipe;

import java.io.IOException;
import java.util.List;


public interface RecipeOperations{
	
	
	public Recipe getRecipe(String recipeID) throws  IOException;
	
	public List<Recipe> getRecipesByIngredients(String ingredientsKeywords, int numResults) throws  IOException;
	
	public List<Recipe> getRandomRecipes(String number, String tags) throws  IOException ;
	
	public List<String>  chatBot(String text) throws  IOException ;

}