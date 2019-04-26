package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.UserBasket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface UserBasketRepository extends CrudRepository<UserBasket, Long> {

}
