package com.filloasoft.rapideat.recipeservice;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.filloasoft.rapideat.recipe.OldRecipe;

@Service
public interface RecipeService {

    public OldRecipe getRecipe(String recipeID) throws IOException;

    public List<OldRecipe> getRecipesByIngredients(String ingredientsKeywords, int numResults) throws IOException;

}
