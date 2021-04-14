
package com.eCommerce.dream.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Sale {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private Integer quantity;
    @Temporal(TemporalType.TIME)
    private Date currentDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client")
    private Client client;

    @OneToMany(mappedBy = "sale")
    private List<ProductSales> productSalesId;

    public Sale() {}

    public Sale(Long id, BigDecimal amount, Integer quantity, Date currentDate, Client client, List<ProductSales> productSalesId) {
        this.id = id;
        this.amount = amount;
        this.quantity = quantity;
        this.currentDate = currentDate;
        this.client = client;
        this.productSalesId = productSalesId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public List<ProductSales> getProductSalesId() {
        return productSalesId;
    }

    public void setProductSalesId(List<ProductSales> productSalesId) {
        this.productSalesId = productSalesId;
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
