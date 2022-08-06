package com.products.management.productsmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.products.management.productsmanagement.repositories.SaleRepo;

public class SaleService {
    @Autowired
    SaleRepo saleRepo;

}
