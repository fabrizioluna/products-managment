package com.products.management.productsmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.management.productsmanagement.entity.Invoice;
import com.products.management.productsmanagement.entity.PayMethod;
import com.products.management.productsmanagement.repositories.InvoiceRepo;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepo invoiceRepo;

    public Invoice save(PayMethod methodpay) {
        Invoice invoice = new Invoice();
        invoice.setMethod_pay(methodpay);
        return invoiceRepo.save(invoice);
    }
}
