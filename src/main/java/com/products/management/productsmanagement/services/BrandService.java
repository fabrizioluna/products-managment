package com.products.management.productsmanagement.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.management.productsmanagement.entity.Brand;
import com.products.management.productsmanagement.repositories.BrandRepo;

@Service
public class BrandService {
    @Autowired
    BrandRepo brandRepo;

    public Brand create(Brand brand){
        return brandRepo.save(brand);
    }

    public ArrayList<Brand> getAll(){
        return (ArrayList<Brand>) brandRepo.findAll();
    }

    public Optional<Brand> get(Long id){
        return brandRepo.findById(id);
    }

    public String delete(Long id){
        Optional<Brand> product = brandRepo.findById(id);
        if(product.isPresent()){
            brandRepo.deleteById(id);
            return "This brand has been deleted.";
        } 
        return "We can't find this brand id.";
    }
}
