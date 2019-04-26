package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.StepRecipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface StepRecipeRepository extends CrudRepository<StepRecipe, Long> {

}
