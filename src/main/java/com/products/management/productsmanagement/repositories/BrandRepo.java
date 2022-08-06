package com.products.management.productsmanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.products.management.productsmanagement.entity.Brand;

@Repository
public interface BrandRepo extends CrudRepository<Brand, Long> {

}
