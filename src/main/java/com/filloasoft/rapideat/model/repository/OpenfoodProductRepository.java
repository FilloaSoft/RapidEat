package com.filloasoft.rapideat.model.repository;

import com.filloasoft.rapideat.model.entity.OpenfoodProduct;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OpenfoodProductRepository extends JpaRepository<OpenfoodProduct, Long> {
}
