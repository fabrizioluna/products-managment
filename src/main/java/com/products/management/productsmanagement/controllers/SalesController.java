package com.products.management.productsmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.management.productsmanagement.handlers.SaleHandler;
import com.products.management.productsmanagement.handlers.SalesHandler;
import com.products.management.productsmanagement.services.SaleService;

@RestController
@RequestMapping("/sale")
public class SalesController {

    @Autowired
    SaleService saleService;

    @PostMapping("/sale_create")
    public Object createSale(@RequestBody SalesHandler sale) {
        return SaleHandler.registerSale(sale);
    }
}

// Ya quedo toda la parte de la venta de productos