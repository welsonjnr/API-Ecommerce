package com.eCommerce.dream.dto.sale;

import javax.validation.constraints.NotBlank;
import java.lang.Double;

public class NewSaleDTO {

    //Product
    @NotBlank(message = "The Sale cannot be made without product")
    private Long idProduct;
    @NotBlank(message = "The nameProduct cannot be empty")
    private String nameProduct;
    @NotBlank(message = "The quantity cannot be empty")
    private Integer quantity;
    @NotBlank(message = "The price cannot be empty")
    private Double price;

    //Client
    @NotBlank(message = "Customer id cannot be Null or Empty")
    private Long idClient;
    @NotBlank(message = "Customer name cannot be Null or Empty")
    private String nameClient;

    public NewSaleDTO() {}

    public NewSaleDTO(Long idProduct, String nameProduct, Integer quantity, Double price, Long idClient, String nameClient) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.idClient = idClient;
        this.nameClient = nameClient;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
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
}
