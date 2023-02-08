
package com.eCommerce.dream.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.lang.Double;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Price {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double salePrice;
    private Double costPrice;
    private Long percentagePrice;
    public Price() {}

    public Price(Double salePrice, Double costPrice) {
        this.salePrice = salePrice;
        this.costPrice = costPrice;
    }

    public Price(Long id, Double salePrice, Double costPrice, Long percentagePrice) {
        this.id = id;
        this.salePrice = salePrice;
        this.costPrice = costPrice;
        this.percentagePrice = percentagePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Long getPercentagePrice() {
        return percentagePrice;
    }

    public void setPercentagePrice(Long percentagePrice) {
        this.percentagePrice = percentagePrice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Price other = (Price) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
      
}
