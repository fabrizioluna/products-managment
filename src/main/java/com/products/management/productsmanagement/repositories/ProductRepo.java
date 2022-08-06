package com.products.management.productsmanagement.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.products.management.productsmanagement.entity.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
    // find Products by a range of pieces.
    public abstract ArrayList<Product> findByPieces(Integer pieces);
}
