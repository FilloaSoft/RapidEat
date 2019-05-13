package com.filloasoft.rapideat.productservice;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.filloasoft.rapideat.product.Product;
import com.filloasoft.rapideat.product.ProductOperations;


@Service
@Transactional(propagation=Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED, readOnly=false)
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductOperations productOperations;


	@Override
	public Product readProductBarcode(String barcode) {
		
		return productOperations.getProductByBarcode(barcode);

	}


	@Override
	public Product getProductByName(String name) throws IOException {
		return productOperations.getProductByName(name);
	}


	@Override
	public Product getProductCameraImage(String name) throws IOException {
		return productOperations.getProductCameraImage(name);
	}


}

