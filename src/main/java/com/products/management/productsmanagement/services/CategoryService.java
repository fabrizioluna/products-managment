package com.products.management.productsmanagement.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.management.productsmanagement.entity.Category;
import com.products.management.productsmanagement.repositories.CategoryRepo;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public ArrayList<Category> getAll() {
        return (ArrayList<Category>) categoryRepo.findAll();
    }

    public Optional<Category> get(Long id) {
        return categoryRepo.findById(id);
    }

    public Category create(Category category) {
        return categoryRepo.save(category);
    }

    public String delete(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        if (category.isPresent())
            return "Category with the ID " + id + " has been deleted.";
        return "We can't find this category id.";
    }
}
