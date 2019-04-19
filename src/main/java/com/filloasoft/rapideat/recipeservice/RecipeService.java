package com.filloasoft.rapideat.recipeservice;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.filloasoft.rapideat.recipe.Recipe;

import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public interface RecipeService {

	public Recipe getRecipe(String recipeID) throws UnirestException, IOException;
}