package com.filloasoft.rapideat.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class ProductOperationsImpl implements ProductOperations {

	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String barcode) throws IOException, JSONException {
	    InputStream is = new URL("https://world.openfoodfacts.org/api/v0/product/"+barcode+".json").openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	}
	//TODO: falta por mapear máis atributos de producto. Cando o decidamos.
	@Override
	public Product getProductByBarcode(String barcode) {
		JSONObject jsonOutput;
		Product product = new Product();

			try {
				jsonOutput = readJsonFromUrl(barcode);
				product.setId(barcode);
				product.setProduct_name(jsonOutput.getJSONObject("product").get("product_name").toString());

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

	
		return product;
	}
	
	  
}