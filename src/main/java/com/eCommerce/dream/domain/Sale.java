
package com.eCommerce.dream.domain;

import org.joda.time.LocalDate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Sale {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private LocalDate dataSale;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client")
    private Client client;

    @OneToMany(mappedBy = "sale")
    private List<ProductSale> productSaleId;

    public Sale() {}

    public Sale(Long id, BigDecimal amount, LocalDate dataSale, Client client, List<ProductSale> productSaleId) {
        this.id = id;
        this.amount = amount;
        this.dataSale = dataSale;
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

    public LocalDate getDataSale() {
        return dataSale;
    }

    public void setDataSale(LocalDate dataSale) {
        this.dataSale = dataSale;
    }

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
