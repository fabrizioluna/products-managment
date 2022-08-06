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

import com.products.management.productsmanagement.entity.Distributor;
import com.products.management.productsmanagement.services.DistributorService;

@RestController
@RequestMapping("/distributor")
public class DistributorController {
    @Autowired
    DistributorService distributorService;

    @GetMapping("/get_distributors")
    public ArrayList<Distributor> getDistributors(){
        return distributorService.getAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Distributor> getDistributor(@PathVariable("id") Long id){
        return distributorService.get(id);
    }

    @PostMapping("/create_distributor")
    public Distributor createDistributor(@RequestBody Distributor distributor){
        return distributorService.create(distributor);
    }

    @DeleteMapping("/delete_distributor/{id}")
    public String deleteDistributor(@PathVariable("id") Long id){
        return distributorService.delete(id);
    }
}   
