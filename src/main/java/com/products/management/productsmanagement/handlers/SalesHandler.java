package com.products.management.productsmanagement.handlers;

import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.products.management.productsmanagement.entity.PayMethod;
import com.products.management.productsmanagement.services.ProductService;

@Component
public class SalesHandler {
    private Long productId;
    private ArrayList<Products> products;
    private Boolean defaultPrice;
    private Integer amount;
    private Integer pieces;
    private PayMethod payMethod;
    private LocalTime timestamp = LocalTime.now();

    @Autowired
    ProductService productService;

    public SalesHandler() {
    }

    public SalesHandler(SalesHandler sale) {
        this.productId = sale.productId;
        this.defaultPrice = sale.defaultPrice;
        this.products = sale.products;
        this.amount = sale.amount;
        this.pieces = sale.pieces;
        this.timestamp = sale.timestamp;
    }
    
    public PayMethod getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(PayMethod methodPay) {
        this.payMethod = methodPay;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public ArrayList<Products> getProducts() {
        return this.products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }
    public Boolean getDefaultPrice() {
        return this.defaultPrice;
    }

    public void setDefaultPrice(Boolean defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPieces() {
        return this.pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public LocalTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalTime timestamp) {
        this.timestamp = timestamp;
    }

}
