package com.products.management.productsmanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.products.management.productsmanagement.entity.Distributor;

@Repository
public interface DistributorRepo extends CrudRepository<Distributor, Long> {
    
}
