package com.filloasoft.rapideat.model.entity;

import java.util.List;

import com.filloasoft.rapideat.model.entity.OpenfoodProduct;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SpoonacularRecipe {

    @Id
    private String recipeID;
    private String recipeName;
    @ElementCollection
    private List<OpenfoodProduct> recipeIngredients;
    private String recipeImage;
    private String cookingTimeMinutes;
    @ElementCollection
    private List<String> recipeDiets;
    @ElementCollection
    private List<String> recipeInstructions;
    @ElementCollection
    private List<OpenfoodProduct> unusedIngredients;

    public String getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(String recipeID) {
        this.recipeID = recipeID;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<OpenfoodProduct> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<OpenfoodProduct> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(String recipeImage) {
        this.recipeImage = recipeImage;
    }

    public String getCookingTimeMinutes() {
        return cookingTimeMinutes;
    }

    public void setCookingTimeMinutes(String cookingTimeMinutes) {
        this.cookingTimeMinutes = cookingTimeMinutes;
    }

    public List<String> getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(List<String> recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    public List<String> getRecipeDiets() {
        return recipeDiets;
    }

    public void setRecipeDiets(List<String> recipeDiets) {
        this.recipeDiets = recipeDiets;
    }

    public List<OpenfoodProduct> getUnusedIngredients() {
        return unusedIngredients;
    }

    public void setUnusedIngredients(List<OpenfoodProduct> unusedIngredients) {
        this.unusedIngredients = unusedIngredients;
    }
}
