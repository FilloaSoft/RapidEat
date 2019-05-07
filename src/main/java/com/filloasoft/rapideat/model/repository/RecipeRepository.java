package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
