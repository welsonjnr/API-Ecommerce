
package com.eCommerce.dream.domain;

import com.eCommerce.dream.enums.SaleStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.lang.Double;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Sale {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double amount;
    private LocalDateTime dataSale;

    @Enumerated(value = EnumType.STRING)
    private SaleStatus saleStatus;

    private String client;

    @JsonManagedReference
    @OneToMany(mappedBy = "sale")
    private List<ProductSale> productSaleId;

    public Sale() {}

    public Sale(Long id, Double amount, LocalDateTime dataSale, SaleStatus saleStatus, String client, List<ProductSale> productSaleId) {
        this.id = id;
        this.amount = amount;
        this.dataSale = dataSale;
        this.saleStatus = saleStatus;
        this.productSaleId = productSaleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDataSale() {
        return dataSale;
    }

    public void setDataSale(LocalDateTime dataSale) {
        this.dataSale = dataSale;
    }

    public SaleStatus getSaleStatus() { return saleStatus; }

    public void setSaleStatus(SaleStatus saleStatus) { this.saleStatus = saleStatus; }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<ProductSale> getProductSalesId() {
        return productSaleId;
    }

    public void setProductSalesId(List<ProductSale> productSaleId) {
        this.productSaleId = productSaleId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Sale other = (Sale) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
