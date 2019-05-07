package com.filloasoft.rapideat.service;

import com.filloasoft.rapideat.service.OpenfoodProductOperations;
import com.filloasoft.rapideat.model.entity.OpenfoodProduct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class OpenfoodProductOperationsImpl implements OpenfoodProductOperations {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String barcode) throws IOException, JSONException {
        InputStream is = new URL("http://world.openfoodfacts.org/api/v0/product/" + barcode + ".json").openStream();
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
    public OpenfoodProduct getProductByBarcode(String barcode) {
        JSONObject jsonOutput;
        OpenfoodProduct product = new OpenfoodProduct();

        try {
            jsonOutput = readJsonFromUrl(barcode);
            product.setId(barcode);
            product.setProduct_name(jsonOutput.getJSONObject("product").get("product_name").toString());
            product.setGeneric_name(jsonOutput.getJSONObject("product").get("generic_name").toString());
            product.setBrands(jsonOutput.getJSONObject("product").get("brands").toString());

            JSONArray arr3 = jsonOutput.getJSONObject("product").getJSONArray("ingredients_tags");
            List<String> listIngredients = new ArrayList<String>();
            for (int a = 0; a < arr3.length(); a++) {
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
            for (int i = 0; i < arr.length(); i++) {
                listCategories.add(arr.getString(i).substring(3).replace("-", " "));
            }
            product.setCategories_hierarchy(listCategories);

            JSONArray arr2 = jsonOutput.getJSONObject("product").getJSONArray("allergens_hierarchy");
            List<String> listAllergens = new ArrayList<String>();
            for (int a = 0; a < arr2.length(); a++) {
                listAllergens.add(arr2.getString(a).substring(3).replace("-", " "));
            }
            product.setAllergens(listAllergens);

            JSONArray arr4 = jsonOutput.getJSONObject("product").getJSONArray("labels_tags");
            List<String> listTags = new ArrayList<String>();
            for (int a = 0; a < arr4.length(); a++) {
                listTags.add(arr4.getString(a).substring(3).replace("-", " "));
            }
            product.setLabel_tags(listTags);

        } catch (JSONException e) {
        } catch (IOException e) {
        }

        return product;
    }

}
