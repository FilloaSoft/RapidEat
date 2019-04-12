package com.filloasoft.rapideat.productservice;

import org.springframework.stereotype.Service;

import com.filloasoft.rapideat.product.Product;

@Service
public interface ProductService {

	public Product readProductBarcode(String barcode);
}