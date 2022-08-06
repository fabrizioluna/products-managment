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

import com.products.management.productsmanagement.entity.Category;
import com.products.management.productsmanagement.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/get_categories")
    public ArrayList<Category> getCategories(){
        return categoryService.getAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Category> getCategory(@PathVariable("id") Long id){
        return categoryService.get(id);
    }

    @PostMapping("/create_category")
    public Category createCategory(@RequestBody Category category){
        return categoryService.create(category);
    }

    @DeleteMapping("/delete_category/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        return categoryService.delete(id);
    }
}
