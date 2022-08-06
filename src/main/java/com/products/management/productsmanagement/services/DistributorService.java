package com.products.management.productsmanagement.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.management.productsmanagement.entity.Distributor;
import com.products.management.productsmanagement.repositories.DistributorRepo;

@Service
public class DistributorService {
    @Autowired
    DistributorRepo distributorRepo;

    public ArrayList<Distributor> getAll() {
        return (ArrayList<Distributor>) distributorRepo.findAll();
    }

    public Distributor create(Distributor distributor) {
        return distributorRepo.save(distributor);
    }

    public Optional<Distributor> get(Long id) {
        return distributorRepo.findById(id);
    }

    public String delete(Long id) {
        Optional<Distributor> distributor = distributorRepo.findById(id);
        if (distributor.isPresent())
            return "The distributor with ID: " + id + " has been deleted.";
        return "We can't find this distributor.";
    }
}
