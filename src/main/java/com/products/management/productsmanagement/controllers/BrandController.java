package com.products.management.productsmanagement.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.management.productsmanagement.entity.Brand;
import com.products.management.productsmanagement.services.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandService brandService;

    @GetMapping("/get_brands")
    public ArrayList<Brand> getBrands(){
        return brandService.getAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Brand> getBrand(@PathVariable("id") Long id){
        return brandService.get(id);
    }

    @PostMapping("/create_brand")
    public Brand createBrand(@RequestBody Brand brand){
        return brandService.create(brand);
    }

    @DeleteMapping("/delete_brand/{id}")
    public String deleteBrand(@PathVariable("id") Long id){
        return brandService.delete(id);
    }
}
