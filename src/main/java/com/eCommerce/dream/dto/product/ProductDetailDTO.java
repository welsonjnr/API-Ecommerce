package com.eCommerce.dream.dto.product;

import com.eCommerce.dream.domain.*;

import java.util.List;

public class ProductDetailDTO {

    private Long id;
    private String nameProduct;
    private String description;
    private String shortDescription;
    private String specifications;
    private Integer quantity;
    private Boolean available;
    private String size;
    private String brand;
    private String unity;

    private Price price;

    private List<Category> category;

    private ProductSale productSale;

    public ProductDetailDTO() {}

    public ProductDetailDTO(Product prod) {
        this.id = prod.getId();
        this.nameProduct = prod.getName();
        this.description = prod.getDescription();
        this.shortDescription = prod.getShortDescription();
        this.specifications = prod.getSpecifications();
        this.quantity = prod.getQuantity();
        this.available = prod.getAvailable();
        this.size = prod.getSize();
        this.brand = prod.getBrand();
        this.unity = prod.getUnity();
        this.price = prod.getPrice();
        this.category = prod.getCategory();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public ProductSale getProductSale() {
        return productSale;
    }

    public void setProductSale(ProductSale productSale) {
        this.productSale = productSale;
    }
}
