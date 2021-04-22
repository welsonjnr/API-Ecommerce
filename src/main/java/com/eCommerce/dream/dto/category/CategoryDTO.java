package com.eCommerce.dream.dto.category;

import com.eCommerce.dream.domain.Category;

public class CategoryDTO {

    private String name;
    private Integer totalProducts;
    private Integer totalSubcategories;

    public CategoryDTO(){}

    public CategoryDTO(Category category){
        this.name = category.getName();
        this.totalProducts = category.getProduct().size();
        this.totalSubcategories = category.getSubcategories().size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }

    public Integer getTotalSubcategories() {
        return totalSubcategories;
    }

    public void setTotalSubcategories(Integer totalSubcategories) {
        this.totalSubcategories = totalSubcategories;
    }
}
