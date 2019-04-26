package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.UserAllergy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface UserAllergyRepository extends CrudRepository<UserAllergy, Long> {

}
