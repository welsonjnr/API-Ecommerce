package com.eCommerce.dream.dto.category;

import com.eCommerce.dream.domain.Category;
import com.eCommerce.dream.domain.Product;
import com.eCommerce.dream.domain.Subcategories;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CategoryNewDTO {

    @NotBlank(message = "Category name cannot be null")
    private String name;
    private List<Long> subcategories;
    private List<Long> products;

    public CategoryNewDTO(){}

    public CategoryNewDTO(String name) {
        this.name = name;
    }

    public CategoryNewDTO(String name, List<Long> subcategories, List<Long> products) {
        this.name = name;
        this.subcategories = subcategories;
        this.products = products;
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

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
        this.products = products;
    }
}
