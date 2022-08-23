package com.products.management.productsmanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.products.management.productsmanagement.entity.Invoice;

public interface InvoiceRepo extends CrudRepository<Invoice, Long> {
    
}
