package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.UserDiet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface UserDietRepository extends CrudRepository<UserDiet, Long> {

}
