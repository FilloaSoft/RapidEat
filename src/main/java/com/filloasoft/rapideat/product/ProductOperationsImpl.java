package com.filloasoft.rapideat.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


@Repository
public class ProductOperationsImpl implements ProductOperations {
	
	@Value("${spoonacular.key}")
	private String key;

	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String barcode) throws IOException, JSONException {
	    InputStream is = new URL("http://world.openfoodfacts.org/api/v0/product/"+barcode+".json").openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	}
	
	@Override
	public Product getProductByBarcode(String barcode) {
		JSONObject jsonOutput;
		Product product = new Product();

			try {
				jsonOutput = readJsonFromUrl(barcode);
				product.setId(barcode);
				product.setProduct_name(jsonOutput.getJSONObject("product").get("product_name").toString());
				product.setGeneric_name(jsonOutput.getJSONObject("product").get("generic_name").toString());
				product.setBrands(jsonOutput.getJSONObject("product").get("brands").toString());
				
				JSONArray arr3 = jsonOutput.getJSONObject("product").getJSONArray("ingredients_tags");
				List<String> listIngredients = new ArrayList<String>();
				for(int a = 0; a < arr3.length(); a++){
					listIngredients.add(arr3.getString(a).substring(3).replace("-", " "));
				}
				product.setIngredients_text(listIngredients);
				
				product.setTraces(jsonOutput.getJSONObject("product").get("traces").toString());				
				product.setServing_size(jsonOutput.getJSONObject("product").get("serving_size").toString());
				product.setIngredients_from_palm_oil(jsonOutput.getJSONObject("product").get("ingredients_from_palm_oil_n").toString());
				product.setImage_url(jsonOutput.getJSONObject("product").get("image_url").toString());
				product.setEnergy(jsonOutput.getJSONObject("product").getJSONObject("nutriments").get("energy").toString());
				product.setProteins(jsonOutput.getJSONObject("product").getJSONObject("nutriments").get("proteins").toString());
				product.setCarbohydrates(jsonOutput.getJSONObject("product").getJSONObject("nutriments").get("carbohydrates").toString());
				product.setSugars(jsonOutput.getJSONObject("product").getJSONObject("nutriments").get("sugars").toString());
				product.setFat(jsonOutput.getJSONObject("product").getJSONObject("nutriments").get("fat").toString());
				product.setManufacturing_places(jsonOutput.getJSONObject("product").get("manufacturing_places").toString());
				product.setStores(jsonOutput.getJSONObject("product").get("stores").toString());
				product.setQuantity(jsonOutput.getJSONObject("product").get("quantity").toString());
				product.setNutritionScore(jsonOutput.getJSONObject("product").getJSONObject("nutriments").get("nutrition-score-fr").toString());

				
				JSONArray arr = jsonOutput.getJSONObject("product").getJSONArray("categories_hierarchy");
				List<String> listCategories = new ArrayList<String>();
				for(int i = 0; i < arr.length(); i++){
					listCategories.add(arr.getString(i).substring(3).replace("-", " "));
				}
				product.setCategories_hierarchy(listCategories);
				
				
				JSONArray arr2 = jsonOutput.getJSONObject("product").getJSONArray("allergens_hierarchy");
				List<String> listAllergens = new ArrayList<String>();
				for(int a = 0; a < arr2.length(); a++){
					listAllergens.add(arr2.getString(a).substring(3).replace("-", " "));
				}
				product.setAllergens(listAllergens);
				
				JSONArray arr4 = jsonOutput.getJSONObject("product").getJSONArray("labels_tags");
				List<String> listTags = new ArrayList<String>();
				for(int a = 0; a < arr4.length(); a++){
					listTags.add(arr4.getString(a).substring(3).replace("-", " "));
				}
				product.setLabel_tags(listTags);



			} catch (Exception e) {
				return null;
			}
	
		return product;
	}
	
	public JsonObject getProductinfo(String id)  throws IOException {
		URL url = new URL("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/products/"+id);
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
		
		return convertedObject;
	}

	@Override
	public Product getProductByName(String name)  throws IOException {
		Product product = new Product();
		
		String name2 = name.replaceAll("\\s+", "+");
		URL url = new URL("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/products/search?number=1&query="+name2);
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

		JsonArray arr = convertedObject.getAsJsonArray("products");
		
		try {
			String nmestrg = arr.get(0).getAsJsonObject().get("title").toString();
			product.setProduct_name(nmestrg.substring(1, nmestrg.length()-1));
			
			String imgstrg = arr.get(0).getAsJsonObject().get("image").toString();
			product.setImage_url(imgstrg.substring(1, imgstrg.length()-1));
			
			
			JsonObject convertedObject2 =  getProductinfo(arr.get(0).getAsJsonObject().get("id").toString());
			JsonArray arr1 = convertedObject2.getAsJsonArray("badges");
			
			List<String> badgeslist = new ArrayList<String>();
			for(int i = 0; i < arr1.size(); i++){			
				badgeslist.add(arr1.get(i).toString().replaceAll("[^\\w\\s]","").replaceAll("_"," "));
			}
			
			product.setAllergens(badgeslist);
			
			JsonArray arr2 = convertedObject2.getAsJsonArray("ingredients");
			
			List<String> inglist = new ArrayList<String>();
			for(int i = 0; i < arr2.size(); i++){			
				inglist.add(arr2.get(i).getAsJsonObject().get("name").toString().replaceAll("[^\\w\\s]",""));
			}
			
			product.setIngredients_text(inglist);
			
			
			JsonArray arr3 = convertedObject2.getAsJsonArray("breadcrumbs");
			
			List<String> tags = new ArrayList<String>();
			for(int i = 0; i < arr3.size(); i++){			
				tags.add(arr3.get(i).toString().replaceAll("[^\\w\\s]",""));
			}
			
			product.setLabel_tags(tags);
			product.setGeneric_name(tags.get(0));
			
			product.setEnergy(convertedObject2.getAsJsonObject("nutrition").get("calories").toString());
			
			String carbs = convertedObject2.getAsJsonObject("nutrition").get("carbs").toString();
			product.setCarbohydrates(carbs.substring(1, carbs.length()-1));
			String protein =convertedObject2.getAsJsonObject("nutrition").get("protein").toString();
			product.setProteins(protein.substring(1, protein.length()-1));
			String fat =convertedObject2.getAsJsonObject("nutrition").get("fat").toString();
			product.setFat(fat.substring(1, fat.length()-1));
			String serving_size =convertedObject2.get("serving_size").toString();
			product.setServing_size(serving_size.substring(1, serving_size.length()-1));


		}catch(Exception e) {
			return null;
		}
		
		return product;
	}
	
	  
}