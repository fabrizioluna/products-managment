package com.products.management.productsmanagement.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @JoinTable(name = "product_sales", joinColumns = {
        @JoinColumn(name = "sale_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
        @JoinColumn(name = "product_id", referencedColumnName = "id")
    })
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> product;

    // public Sale(){}
    // public Sale()
    public void addSale(Product product) {
        if (this.product == null) {
            this.product = new ArrayList<>();
        }
        this.product.add(product);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addSale(Optional<Product> product_exist) {
    }

}
