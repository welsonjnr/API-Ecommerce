package com.eCommerce.dream.dto.category;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class CategoryNewDTO {

    @NotBlank(message = "Category name cannot be null")
    private String name;
    private List<Long> subcategories;

    public CategoryNewDTO(){}

    public CategoryNewDTO(String name) {
        this.name = name;
    }

    public CategoryNewDTO(String name, List<Long> subcategories) {
        this.name = name;
        this.subcategories = subcategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Long> subcategories) {
        this.subcategories = subcategories;
    }

}
