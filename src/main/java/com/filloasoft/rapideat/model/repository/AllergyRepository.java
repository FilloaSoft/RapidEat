package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.Allergy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface AllergyRepository extends CrudRepository<Allergy, Long> {

}
