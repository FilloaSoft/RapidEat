package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.IngredientRecipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface IngredientRecipeRepository extends CrudRepository<IngredientRecipe, Long> {

}
