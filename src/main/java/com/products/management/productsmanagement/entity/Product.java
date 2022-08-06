package com.products.management.productsmanagement.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private Integer pieces;
    private Integer price;
    private Integer purchase;
    private Boolean available;
    private Date date;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "distributor_id", nullable = false, updatable = false)
    private Distributor distributor;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false, updatable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, updatable = false)
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_sales", joinColumns = {
            @JoinColumn(name = "product_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "sale_id")
    })
    private List<Sale> sales = new ArrayList<Sale>();

    public Product() {
    }

    public Product(
            Long id,
            String name,
            Integer pieces,
            Integer price,
            Integer purchase,
            Boolean available,
            Distributor distributor,
            Brand brand,
            Category category) {
        this.id = id;
        this.name = name;
        this.pieces = pieces;
        this.price = price;
        this.purchase = purchase;
        this.available = available;
        this.distributor = distributor;
        this.brand = brand;
        this.category = category;
    }

    public List<Sale> getSales() {
        return this.sales;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPieces() {
        return this.pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPurchase() {
        return this.purchase;
    }

    public void setPurchase(Integer purchase) {
        this.purchase = purchase;
    }

    public Boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Distributor getDistributor() {
        return this.distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

}
