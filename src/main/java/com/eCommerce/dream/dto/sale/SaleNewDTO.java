package com.eCommerce.dream.dto.sale;

import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.domain.ProductSale;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class SaleNewDTO {

    @NotBlank(message = "The sale cannot be made without products")
    private List<ProductSale> products;
    @NotBlank(message = "The sale cannot be made without a client")
    private Client client;

    public SaleNewDTO(List<ProductSale> products, Client client) {
        this.products = products;
        this.client = client;
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
