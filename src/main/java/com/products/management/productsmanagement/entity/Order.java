package com.products.management.productsmanagement.entity;

import java.time.LocalTime;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false, updatable = false)
    private Invoice invoice;
    
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    private Product product;

    private LocalTime timestamp;
    private Integer outs;

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Invoice getInvoice() {
        return this.invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public LocalTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getOuts() {
        return this.outs;
    }

    public void setOuts(Integer outs) {
        this.outs = outs;
    }

}
