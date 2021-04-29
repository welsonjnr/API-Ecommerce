package com.eCommerce.dream.dto.subcategories;

import com.eCommerce.dream.domain.Category;
import com.eCommerce.dream.domain.Subcategories;
import com.eCommerce.dream.dto.category.CategoryDTO;

public class SubcategoriesDTO {

    private Long id;
    private String name;
    private CategoryDTO category;

    public SubcategoriesDTO(){}

    public SubcategoriesDTO(Subcategories subcategories) {
        this.id = subcategories.getId();
        this.name = subcategories.getName();
        this.category = new CategoryDTO(subcategories.getCategory());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }


}
