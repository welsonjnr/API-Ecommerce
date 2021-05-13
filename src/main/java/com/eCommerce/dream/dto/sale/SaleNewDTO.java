package com.eCommerce.dream.dto.sale;

import com.eCommerce.dream.domain.Client;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

public class SaleNewDTO {

    private Integer totalProducts;
    private BigDecimal amountOfProducts;
    @NotBlank(message = "Product for sale cannot be empty")
    private List<ProductSaleNewDTO> products;
    @NotBlank(message = "Client cannot bem empty for sale")
    private Client client;

    public SaleNewDTO(List<ProductSaleNewDTO> products, Client client) {
        this.products = products;
        this.client = client;
    }

    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }

    public BigDecimal getAmountOfProducts() {
        return amountOfProducts;
    }

    public void setAmountOfProducts(BigDecimal amountOfProducts) {
        this.amountOfProducts = amountOfProducts;
    }

    public List<ProductSaleNewDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSaleNewDTO> products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
