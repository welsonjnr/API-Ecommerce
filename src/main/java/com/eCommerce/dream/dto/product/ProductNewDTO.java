package com.eCommerce.dream.dto.product;

import com.eCommerce.dream.domain.Category;
import com.eCommerce.dream.domain.Images;
import com.eCommerce.dream.domain.Price;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class ProductNewDTO {

    //Product
    @NotBlank(message = "Product name cannot be null")
    @Size(min = 4, message = "The customer's name must be at least 4 characters")
    private String name;
    @NotBlank(message = "Product description cannot be null")
    @Size(min = 15, message = "The Product description must be at least 15 characters")
    private String description;
    @NotBlank(message = "Product shotDescription cannot be null")
    @Size(min = 10, message = "The Product short description must be at least 10 characters")
    private String shorDescription;
    private String specifications;
    @NotBlank(message = "Product quantity cannot be null")
    private Integer quantity;
    private String size;
    @NotBlank(message = "Product brand cannot be null")
    private String brand;
    private Boolean available = Boolean.TRUE;
    private String unity;
    @NotBlank(message = "Product category cannot be null")
    private Category category;
    @NotBlank(message = "Product prices cannot be null")
    private List<Price> prices;
    @NotBlank(message = "Product imgs cannot be null")
    private List<Images> imgs;

    public ProductNewDTO() {}

    public ProductNewDTO(String name, String description, String shorDescription, String specifications, Integer quantity,
                         String size, String brand, Boolean available, String unity, Category category, List<Price> prices) {
        this.name = name;
        this.description = description;
        this.shorDescription = shorDescription;
        this.specifications = specifications;
        this.quantity = quantity;
        this.size = size;
        this.brand = brand;
        this.available = available;
        this.unity = unity;
        this.category = category;
        this.prices = prices;
    }

    public ProductNewDTO(String name, String description, String shorDescription, String specifications, Integer quantity, String size,
                         String brand, Boolean available, String unity, Category category, List<Price> prices, List<Images> imgs) {
        this.name = name;
        this.description = description;
        this.shorDescription = shorDescription;
        this.specifications = specifications;
        this.quantity = quantity;
        this.size = size;
        this.brand = brand;
        this.available = available;
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
