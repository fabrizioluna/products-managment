package com.products.management.productsmanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.products.management.productsmanagement.entity.Order;

public interface OrderRepo extends CrudRepository<Order, Long> {

}
