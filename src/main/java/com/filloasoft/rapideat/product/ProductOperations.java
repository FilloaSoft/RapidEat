package com.filloasoft.rapideat.product;

import java.io.IOException;

public interface ProductOperations{
	
	public  Product getProductByBarcode(String barcode);
	
	public  Product getProductByName(String name)  throws IOException;
	
}