package com.eCommerce.dream.dto.category;

import com.eCommerce.dream.domain.Category;

public class CategoryDTO {

    private String name;
    private Integer totalSubcategories;

    public CategoryDTO(){}

    public CategoryDTO(Category category){
        this.name = category.getName();
        this.totalSubcategories = category.getSubcategories().size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalSubcategories() {
        return totalSubcategories;
    }

    public void setTotalSubcategories(Integer totalSubcategories) {
        this.totalSubcategories = totalSubcategories;
    }
}
