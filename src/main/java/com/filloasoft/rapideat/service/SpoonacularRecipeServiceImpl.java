package com.filloasoft.rapideat.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.filloasoft.rapideat.model.entity.SpoonacularRecipe;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED, readOnly = false)
public class SpoonacularRecipeServiceImpl implements SpoonacularRecipeService {

    @Autowired
    private SpoonacularRecipeOperations recipeOperations;

    @Override
    public SpoonacularRecipe getRecipe(String recipeID) throws IOException {
        return recipeOperations.getRecipe(recipeID);
    }

    @Override
    public List<SpoonacularRecipe> getRecipesByIngredients(String ingredientsKeywords, int numResults) throws IOException {
        return recipeOperations.getRecipesByIngredients(ingredientsKeywords, 5);
    }

    @Override
    public List<SpoonacularRecipe> getRandomRecipes(String number, String tags) throws IOException {
        return recipeOperations.getRandomRecipes(number, tags);
    }

}
