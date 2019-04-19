package com.filloasoft.rapideat.recipe;

import java.io.IOException;

import com.mashape.unirest.http.exceptions.UnirestException;

public interface RecipeOperations{
	
	
	public Recipe getRecipe(String recipeID) throws UnirestException, IOException;
	
}