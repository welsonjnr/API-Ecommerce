package com.eCommerce.dream.dto.sale;

import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.domain.ProductSale;
import com.eCommerce.dream.domain.Sale;
import com.eCommerce.dream.enums.SaleStatus;
import jakarta.validation.constraints.NotBlank;

import java.lang.Double;
import java.time.LocalDateTime;
import java.util.List;

public class SaleDTO {

    private Long idSale;
    private Integer totalProducts;
    private Double amountSale;
    private LocalDateTime dataSale;

    private SaleStatus saleStatus;
    @NotBlank(message = "The sale cannot be made without products")
    private List<ProductSale> productsSale;
    @NotBlank(message = "The sale cannot be made without a client")
    private Client client;

    public SaleDTO(Sale sale) {
        this.idSale = sale.getId();
        this.productsSale = sale.getProductSalesId();
        this.client = sale.getClient();
        this.amountSale = sale.getAmount();
        this.dataSale = sale.getDataSale();
        this.saleStatus = sale.getSaleStatus();
        this.totalProducts = sale.getProductSalesId().size();
    }

    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }

    public Double getAmountSale() {
        return amountSale;
    }

    public void setAmountSale(Double amountSale) {
        this.amountSale = amountSale;
    }

    public LocalDateTime getDataSale() {
        return dataSale;
    }

    public void setDataSale(LocalDateTime dataSale) {
        this.dataSale = dataSale;
    }

    public List<ProductSale> getProductsSale() {
        return productsSale;
    }

    public void setProductsSale(List<ProductSale> productsSale) {
        this.productsSale = productsSale;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getIdSale() {
        return idSale;
    }

    public void setIdSale(Long idSale) {
        this.idSale = idSale;
    }

    public SaleStatus getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }
}