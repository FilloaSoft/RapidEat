package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.Basket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface BasketRepository extends CrudRepository<Basket, Long> {

}
