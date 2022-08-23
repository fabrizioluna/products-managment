package com.products.management.productsmanagement.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.management.productsmanagement.entity.Product;
import com.products.management.productsmanagement.entity.Sale;
import com.products.management.productsmanagement.handlers.SaleHandler;
import com.products.management.productsmanagement.handlers.SalesHandler;
import com.products.management.productsmanagement.repositories.SaleRepo;

@Service
public class SaleService {
    @Autowired
    SaleRepo saleRepo;

    @Autowired
    ProductService productService;

    // public Object save(SalesHandler sale) {
    //     // SalesHandler instanceSale = new SalesHandler(sale);
    //     Boolean product_exist = SaleHandler.productHasExist(sale.getProductId());
    //     // Optional<Product> product_exist =
    //     // productService.existProduct(sale.getProductId());

    //     if (product_exist) {
    //         Sale register_sale = new Sale();
    //         register_sale.setMethod_pay(sale.getPayMethod());
    //         // register_sale.addSale(product_exist);
    //         saleRepo.save(register_sale);
    //         return sale;
    //     } else {
    //         System.out.println("El producto no existe");
    //         return "Ocurrio un error";
    //     }
    // }

}
