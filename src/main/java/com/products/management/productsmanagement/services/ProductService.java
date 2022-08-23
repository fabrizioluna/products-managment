package com.products.management.productsmanagement.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.management.productsmanagement.entity.Product;
import com.products.management.productsmanagement.repositories.ProductRepo;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public Optional<Product> existProduct(Long id) {
        return productRepo.findById(id);
    }

    public ArrayList<Product> getAll() {
        return (ArrayList<Product>) productRepo.findAll();
    }

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public Product get(Long id) {
        return productRepo.findById(id).get();
    }

    public String delete(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            productRepo.deleteById(id);
            return "This product has been deleted.";
        }
        return "We can't find this product id.";
    }
}
