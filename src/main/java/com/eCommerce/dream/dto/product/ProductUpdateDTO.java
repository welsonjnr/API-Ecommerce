package com.eCommerce.dream.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductUpdateDTO {

    //Product
    @NotBlank(message = "Product name cannot be null")
    @Size(min = 4, message = "The customer's name must be at least 4 characters")
    private String name;
    @NotBlank(message = "Product description cannot be null")
    @Size(min = 7, message = "The Product description must be at least 7 characters")
    private String description;
    @NotBlank(message = "Product shotDescription cannot be null")
    @Size(min = 10, message = "The Product short description must be at least 10 characters")
    private String shorDescription;
    private String specifications;
    @Min(value = 1, message= "Product quantity cannot be null")
    private Integer quantity;
    private String size;
    @NotBlank(message = "Product brand cannot be null")
    private String brand;
    private String unity;

    @Min(value = 0L, message = "Product prices cannot be empty")
    private Double salePrice;
    @Min(value = 0L, message = "Product price cost cannot be empty")
    private Double costPrice;


    public ProductUpdateDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShorDescription() {
        return shorDescription;
    }

    public void setShorDescription(String shorDescription) {
        this.shorDescription = shorDescription;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }
}
