package com.eCommerce.dream.dto.sale;

import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.domain.ProductSale;
import com.eCommerce.dream.domain.Sale;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SaleDTO {

    private Integer totalProducts;
    private BigDecimal amountSale;
    private LocalDateTime dataSale;
    @NotBlank(message = "The sale cannot be made without products")
    private List<ProductSale> products;
    @NotBlank(message = "The sale cannot be made without a client")
    private Client client;

    public SaleDTO(Sale sale) {
        this.products = sale.getProductSalesId();
        this.client = sale.getClient();
        this.amountSale = sale.getAmount();
        this.dataSale = sale.getDataSale();
        this.totalProducts = sale.getProductSalesId().size();
    }

    public BigDecimal getAmountSale() {
        return amountSale;
    }

    public void setAmountSale(BigDecimal amountSale) {
        this.amountSale = amountSale;
    }

    public LocalDateTime getDataSale() {
        return dataSale;
    }

    public void setDataSale(LocalDateTime dataSale) {
        this.dataSale = dataSale;
    }

    public List<ProductSale> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSale> products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
