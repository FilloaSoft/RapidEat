package com.filloasoft.rapideat.productservice;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filloasoft.rapideat.product.Product;

@RestController
public class ProductController {
	
    @Autowired
    ProductService productService;
    
    @GetMapping("/product/{id}")
	public Product getProduct(@PathVariable String id) {
		return productService.readProductBarcode(id);
	}

    //example: http://localhost:8085/product/search?name=burger+cheese
    @GetMapping("/product/search")
   	public Product getProductbyName(@RequestParam String name) throws IOException {
   		return productService.getProductByName(name);
   	}
}
