package com.eCommerce.dream.dto.sale;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class NewSaleDTO {

    //Client
    @NotNull(message = "Customer id cannot be Null or Empty")
    private Long idClient;
    @NotEmpty(message = "Customer name cannot be Null or Empty")
    private String nameClient;

    //Products
    @NotNull
    private List<ProductSaleDTO> products;

    public NewSaleDTO() {}

    public NewSaleDTO(Long idClient, String nameClient, List<ProductSaleDTO> products) {
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.products = products;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public List<ProductSaleDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSaleDTO> products) {
        this.products = products;
    }
}
