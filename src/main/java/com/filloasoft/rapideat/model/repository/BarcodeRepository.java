package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.Barcode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Adrian
 */
@Repository
public interface BarcodeRepository extends CrudRepository<Barcode, Long> {

}
