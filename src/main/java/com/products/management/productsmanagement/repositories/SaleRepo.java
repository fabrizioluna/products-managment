package com.products.management.productsmanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.products.management.productsmanagement.entity.Sale;

@Repository
public interface SaleRepo extends CrudRepository<Sale, Long> {
    
}
