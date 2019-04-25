package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Adrian
 */
public interface UserRepository extends CrudRepository<User, Long>{
    
}
