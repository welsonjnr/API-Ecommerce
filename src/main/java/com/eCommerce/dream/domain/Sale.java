
package com.eCommerce.dream.domain;

import com.eCommerce.dream.enums.SaleStatus;

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
    private Date dataSale;

    @Enumerated(value = EnumType.STRING)
    private SaleStatus saleStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client")
    private Client client;

    @OneToMany(mappedBy = "sale")
    private List<ProductSale> productSaleId;

    public Sale() {}

    public Sale(Long id, BigDecimal amount, Date dataSale, SaleStatus saleStatus, Client client, List<ProductSale> productSaleId) {
        this.id = id;
        this.amount = amount;
        this.dataSale = dataSale;
        this.saleStatus = saleStatus;
        this.client = client;
        this.productSaleId = productSaleId;
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

    public Date getDataSale() {
        return dataSale;
    }

    public void setDataSale(Date dataSale) {
        this.dataSale = dataSale;
    }

    public SaleStatus getSaleStatus() { return saleStatus; }

    public void setSaleStatus(SaleStatus saleStatus) { this.saleStatus = saleStatus; }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
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
