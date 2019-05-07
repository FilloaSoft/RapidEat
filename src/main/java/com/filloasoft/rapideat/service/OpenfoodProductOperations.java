package com.filloasoft.rapideat.service;

import com.filloasoft.rapideat.model.entity.OpenfoodProduct;

public interface OpenfoodProductOperations {

    public OpenfoodProduct getProductByBarcode(String barcode);

}
