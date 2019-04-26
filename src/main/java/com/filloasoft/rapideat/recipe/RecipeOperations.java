package com.filloasoft.rapideat.recipe;

import java.io.IOException;
import java.util.List;

public interface RecipeOperations {

    public OldRecipe getRecipe(String recipeID) throws IOException;

    public List<OldRecipe> getRecipesByIngredients(String ingredientsKeywords, int numResults) throws IOException;

}
