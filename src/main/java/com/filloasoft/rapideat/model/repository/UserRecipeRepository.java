package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.UserRecipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface UserRecipeRepository extends CrudRepository<UserRecipe, Long> {

}
