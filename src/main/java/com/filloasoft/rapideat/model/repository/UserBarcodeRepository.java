package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.UserBarcode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface UserBarcodeRepository extends CrudRepository<UserBarcode, Long> {

}
