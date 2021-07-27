package com.eCommerce.dream.dto.product;

import com.eCommerce.dream.domain.Category;
import com.eCommerce.dream.domain.Images;
import com.eCommerce.dream.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductDTO {

    private Long id;
    private String nameProduct;
    private String shotDescription;
    private String brand;
    private Boolean available;
    private Double priceSale;
//    private List<Images> imgs;
    private List<Category> namesCategory;

    public ProductDTO() {}

    public ProductDTO(Product prod) {
        this.id = prod.getId();
        this.nameProduct = prod.getName();
        this.shotDescription = prod.getShortDescription();
        this.brand = prod.getBrand();
        this.available = prod.getAvailable();
        this.priceSale = prod.getPrice().getSalePrice();
//        this.imgs = prod.getImgs();
        this.namesCategory = prod.getCategory();
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

    public String getShotDescription() {
        return shotDescription;
    }

    public void setShotDescription(String shotDescription) {
        this.shotDescription = shotDescription;
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

    public Double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(Double priceSale) {
        this.priceSale = priceSale;
    }
/*
    public List<Images> getImgs() {
        return imgs;
    }

    public void setImgs(List<Images> imgs) {
        this.imgs = imgs;
    }
*/
    public List<Category> getNamesCategory() {
        return namesCategory;
    }

    public void setNamesCategory(List<Category> namesCategory) {
        this.namesCategory = namesCategory;
    }
}
