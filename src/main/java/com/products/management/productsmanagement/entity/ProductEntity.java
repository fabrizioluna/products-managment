package com.products.management.productsmanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity {
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
    private DistributorEntity distributor;

    @ManyToOne
    private BrandEntity brand;

    @ManyToOne
    private CategoryEntity category;
    

    public CategoryEntity getCategory() {
        return this.category;
    }

    public void setCategory(CategoryEntity category) {
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

    public DistributorEntity getDistributor() {
		return this.distributor;
	}

	public void setDistributor(DistributorEntity distributor) {
		this.distributor = distributor;
	}

}
