package com.filloasoft.rapideat.recipeservice;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.filloasoft.rapideat.recipe.Recipe;
import com.filloasoft.rapideat.recipe.RecipeOperations;



@Service
@Transactional(propagation=Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED, readOnly=false)
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeOperations recipeOperations;

	@Override
	public Recipe getRecipe(String recipeID) throws  IOException {
		return recipeOperations.getRecipe(recipeID);
	}

	@Override
	public List<Recipe> getRecipesByIngredients(String ingredientsKeywords, int numResults) throws  IOException {
		return recipeOperations.getRecipesByIngredients(ingredientsKeywords, 5);
	}

	@Override
	public List<Recipe> getRandomRecipes(String number, String tags) throws IOException {
		return recipeOperations.getRandomRecipes(number, tags);
	}

	@Override
	public List<String> chatBot(String text) throws IOException {
		return recipeOperations.chatBot(text);
	}





}

