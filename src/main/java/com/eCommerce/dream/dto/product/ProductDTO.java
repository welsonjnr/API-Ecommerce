package com.eCommerce.dream.dto.product;

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
    private BigDecimal priceSale;
    private List<Images> imgs;
    private String nameCategory;

    public ProductDTO() {}

    public ProductDTO(Product prod) {
        this.id = prod.getId();
        this.nameProduct = prod.getName();
        this.shotDescription = prod.getShortDescription();
        this.brand = prod.getBrand();
        this.available = prod.getAvailable();
        this.priceSale = prod.getPrices().get(prod.getPrices().size()).getSalePrice();
        this.imgs = prod.getImgs();
        this.nameCategory = prod.getCategory().getName();
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

    public BigDecimal getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(BigDecimal priceSale) {
        this.priceSale = priceSale;
    }

    public List<Images> getImgs() {
        return imgs;
    }

    public void setImgs(List<Images> imgs) {
        this.imgs = imgs;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
