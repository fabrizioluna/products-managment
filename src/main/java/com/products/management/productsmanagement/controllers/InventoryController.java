package com.products.management.productsmanagement.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.management.productsmanagement.entity.Product;
import com.products.management.productsmanagement.services.ProductService;
import com.products.management.productsmanagement.utils.CurrentDate;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    ProductService productService;

    @GetMapping("/get_products")
    public ArrayList<Product> getProducts() {
        return productService.getAll();
    }
    
    // @GetMapping("/get_products")
    // public Product getProduct(@PathVariable("id") Long) {
    //     return productService.get();
    // }

    @PostMapping("/create_product")
    public Product createProduct(@Validated @RequestBody Product product) {
        product.setDate(CurrentDate.nowDate());
        return productService.save(product);
    }

    @DeleteMapping("/delete_product/{id}")
    public Product deleteProduct(@PathVariable("id") Long id) {
        return deleteProduct(id);
    }
}
