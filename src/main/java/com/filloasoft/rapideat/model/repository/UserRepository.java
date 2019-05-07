package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
