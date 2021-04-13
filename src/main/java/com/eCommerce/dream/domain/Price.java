
package com.eCommerce.dream.domain;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Price {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal salePrice;
    private BigDecimal costPrice;
    private Long percentagePrice;
    
    @ManyToOne
    @JoinColumn(name="product_price_id")
    private Product product;

    public Price() {}

    public Price(Long id, BigDecimal salePrice, BigDecimal costPrice, Long percentagePrice, Product product) {
        this.id = id;
        this.salePrice = salePrice;
        this.costPrice = costPrice;
        this.percentagePrice = percentagePrice;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public Long getPercentagePrice() {
        return percentagePrice;
    }

    public void setPercentagePrice(Long percentagePrice) {
        this.percentagePrice = percentagePrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
