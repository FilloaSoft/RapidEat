package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Adrian
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long>{
    
}
