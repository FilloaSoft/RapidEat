package com.filloasoft.rapideat.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.filloasoft.rapideat.product.OldProduct;
import com.filloasoft.rapideat.product.ProductOperations;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED, readOnly = false)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductOperations productOperations;

    @Override
    public OldProduct readProductBarcode(String barcode) {

        return productOperations.getProductByBarcode(barcode);

    }

}
