package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.Diet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface DietRepository extends CrudRepository<Diet, Long> {

}
