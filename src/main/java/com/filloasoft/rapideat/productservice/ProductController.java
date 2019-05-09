package com.filloasoft.rapideat.productservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/example")
	public Product newExample(@RequestBody Product newExample) {
		return null;
	}
}
