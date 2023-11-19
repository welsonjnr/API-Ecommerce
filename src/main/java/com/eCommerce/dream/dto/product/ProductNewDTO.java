package com.eCommerce.dream.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.Double;

public class ProductNewDTO {

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
    private Boolean available = Boolean.TRUE;
    private String unity;

    //Category
    @NotBlank(message = "Category cannot be null")
    private String nameCategory;

    //Price
    @Min(value = 0L, message = "Product prices cannot be empty")
    private Double salePrice;
    @Min(value = 0L, message = "Product price cost cannot be empty")
    private Double costPrice;

    public ProductNewDTO() {}

    public ProductNewDTO(String name, String description, String shorDescription, String specifications, Integer quantity, String size, String brand, Boolean available, String unity, String nameCategory, Double salePrice, Double costPrice) {
        this.name = name;
        this.description = description;
        this.shorDescription = shorDescription;
        this.specifications = specifications;
        this.quantity = quantity;
        this.size = size;
        this.brand = brand;
        this.available = available;
        this.unity = unity;
        this.nameCategory = nameCategory;
        this.salePrice = salePrice;
        this.costPrice = costPrice;
    }

    public ProductNewDTO(String name, String description, String shorDescription, Integer quantity, String brand, Boolean available, Double salePrice, Double costPrice) {
        this.name = name;
        this.description = description;
        this.shorDescription = shorDescription;
        this.quantity = quantity;
        this.brand = brand;
        this.available = available;
        this.salePrice = salePrice;
        this.costPrice = costPrice;
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
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
