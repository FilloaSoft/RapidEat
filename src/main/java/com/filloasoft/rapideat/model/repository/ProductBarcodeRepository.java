package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Adrian
 */
public interface ProductBarcodeRepository extends CrudRepository<Product, Long>{
    
}
