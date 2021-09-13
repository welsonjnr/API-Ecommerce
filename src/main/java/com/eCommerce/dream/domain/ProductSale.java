/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eCommerce.dream.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.lang.Double;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class ProductSale {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private Double preco;
    private Double amountSaleProduct;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="sale_id")
    private Sale sale;

    public ProductSale() {}

    public ProductSale(Long id, Integer quantity, Double preco, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.preco = preco;
        this.product = product;
    }

    public ProductSale(Long id, Integer quantity, Double preco, Double amountSaleProduct, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.preco = preco;
        this.amountSaleProduct = amountSaleProduct;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getAmountSaleProduct() {
        return amountSaleProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductSale other = (ProductSale) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
