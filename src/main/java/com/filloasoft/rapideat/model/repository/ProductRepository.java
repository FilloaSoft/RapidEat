package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
