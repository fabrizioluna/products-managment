package com.products.management.productsmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.management.productsmanagement.entity.Order;
import com.products.management.productsmanagement.repositories.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    public Order save(Order order){
        return orderRepo.save(order);
    }
}
