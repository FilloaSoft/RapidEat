package com.filloasoft.rapideat.recipeservice;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.filloasoft.rapideat.recipe.Recipe;
import com.filloasoft.rapideat.recipe.RecipeOperations;

import com.mashape.unirest.http.exceptions.UnirestException;


@Service
@Transactional(propagation=Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED, readOnly=false)
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeOperations recipeOperations;

	@Override
	public Recipe getRecipe(String recipeID) throws UnirestException, IOException {
		return recipeOperations.getRecipe(recipeID);
	}





}

