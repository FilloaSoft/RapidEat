package com.filloasoft.rapideat.product;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ExampleRepository extends JpaRepository<OldProduct, Long> {
}
