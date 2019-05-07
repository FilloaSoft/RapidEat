package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.BasketProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface BasketProductRepository extends CrudRepository<BasketProduct, Long> {

}
