package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Adrian
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
    
}
