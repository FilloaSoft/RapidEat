package com.filloasoft.rapideat.recipe;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.filloasoft.rapideat.product.Product;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mashape.unirest.http.exceptions.UnirestException;





@Repository
public class RecipeOperationsImpl implements RecipeOperations {
	//resources -> application.properties
	
	@Value("${spoonacular.key}")
	private String key;
	
	@Override
	public Recipe getRecipe(String recipeID) throws UnirestException, IOException {
		
		URL url = new URL("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/"+recipeID+"/information");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com");
		con.setRequestProperty("X-RapidAPI-Key", key);
		
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);
		
		String json = body;
		JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);
		
		Recipe recipe = new Recipe();
		
		recipe.setRecipeID(recipeID);
		recipe.setRecipeName(convertedObject.get("title").toString().replaceAll("[^\\w\\s]",""));
		recipe.setCookingTimeMinutes(convertedObject.get("readyInMinutes").toString());
		
		JsonArray arr = convertedObject.getAsJsonArray("diets");
		List<String> listDiets = new ArrayList<String>();
		for(int i = 0; i < arr.size(); i++){
			listDiets.add(arr.get(i).toString().replaceAll("[^\\w\\s]",""));
		}
		recipe.setRecipeDiets(listDiets);
		String imagen = convertedObject.get("image").toString();
		recipe.setRecipeImage(imagen.substring(1,imagen.length()-1));
		
		JsonArray arr1 = convertedObject.getAsJsonArray("extendedIngredients");
		List<Product> listIngredients = new ArrayList<Product>();
		for(int i = 0; i < arr1.size(); i++){
			Product p = new Product();
			p.setProduct_name(arr1.get(i).getAsJsonObject().get("name").toString().replaceAll("[^\\w\\s]",""));
			List<String> categ_hier = new ArrayList<String>();
			categ_hier.add(arr1.get(i).getAsJsonObject().get("aisle").toString().replace(";", " ").replaceAll("[^\\w\\s]",""));
			p.setCategories_hierarchy(categ_hier);
			listIngredients.add(p);
		}
		recipe.setRecipeIngredients(listIngredients);
		
		JsonArray arr2 = convertedObject.getAsJsonArray("analyzedInstructions");
		List<String> listSteps = new ArrayList<String>();
		JsonArray arr3 = arr2.get(0).getAsJsonObject().getAsJsonArray("steps");
		
		for(int i = 0; i < arr3.size(); i++){
			listSteps.add(arr3.get(i).getAsJsonObject().get("step").toString().replaceAll("[^\\w\\s]",""));
		}
		
		recipe.setRecipeInstructions(listSteps);
		
				
		return recipe;
		
	}
		
}