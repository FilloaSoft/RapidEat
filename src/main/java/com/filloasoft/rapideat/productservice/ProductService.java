package com.filloasoft.rapideat.productservice;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.filloasoft.rapideat.product.Product;

@Service
public interface ProductService {

	public Product readProductBarcode(String barcode);
	
	public  Product getProductByName(String name)  throws IOException;

	public Product getProductCameraImage(String name)  throws IOException;


}