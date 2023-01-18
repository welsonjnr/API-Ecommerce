package com.eCommerce.dream.dto.sale;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class NewSaleDTO {

    //Client
    @NotEmpty(message = "Customer name cannot be Null or Empty")
    private String nameClient;

    //Products
    @NotNull
    private List<ProductSaleDTO> products;

    public NewSaleDTO() {}

    public NewSaleDTO(String nameClient, List<ProductSaleDTO> products) {
        this.nameClient = nameClient;
        this.products = products;
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
