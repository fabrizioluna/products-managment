
package com.products.management.productsmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    private PayMethod method_pay;

    public PayMethod getMethod_pay() {
        return this.method_pay;
    }

    public void setMethod_pay(PayMethod method_pay) {
        this.method_pay = method_pay;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
