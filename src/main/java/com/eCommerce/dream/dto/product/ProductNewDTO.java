package com.eCommerce.dream.dto.product;

import com.eCommerce.dream.domain.Category;
import com.eCommerce.dream.domain.Images;
import com.eCommerce.dream.domain.Price;

import java.util.List;

public class ProductNewDTO {

    private String name;
    private String description;
    private String shorDescription;
    private String specifications;
    private Integer quantity;
    private String size;
    private String brand;
    private String unity;
    private Category category;
    private List<Price> prices;
    private List<Images> imgs;

    public ProductNewDTO() {}

    public ProductNewDTO(String name, String description, String shorDescription, String specifications, Integer quantity,
                         String size, String brand, String unity, Category category, List<Price> prices) {
        this.name = name;
        this.description = description;
        this.shorDescription = shorDescription;
        this.specifications = specifications;
        this.quantity = quantity;
        this.size = size;
        this.brand = brand;
        this.unity = unity;
        this.category = category;
        this.prices = prices;
    }

    public ProductNewDTO(String name, String description, String shorDescription, String specifications, Integer quantity, String size,
                         String brand, String unity, Category category, List<Price> prices, List<Images> imgs) {
        this.name = name;
        this.description = description;
        this.shorDescription = shorDescription;
        this.specifications = specifications;
        this.quantity = quantity;
        this.size = size;
        this.brand = brand;
        this.unity = unity;
        this.category = category;
        this.prices = prices;
        this.imgs = imgs;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<Images> getImgs() {
        return imgs;
    }

    public void setImgs(List<Images> imgs) {
        this.imgs = imgs;
    }
}
