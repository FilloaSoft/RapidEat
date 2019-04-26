package com.filloasoft.rapideat.productservice;

import org.springframework.stereotype.Service;

import com.filloasoft.rapideat.product.OldProduct;

@Service
public interface ProductService {

    public OldProduct readProductBarcode(String barcode);
}
