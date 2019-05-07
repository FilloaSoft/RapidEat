package com.filloasoft.rapideat.service;

import org.springframework.stereotype.Service;

import com.filloasoft.rapideat.model.entity.OpenfoodProduct;

@Service
public interface OpenfoodProductService {

    public OpenfoodProduct readProductBarcode(String barcode);
}
