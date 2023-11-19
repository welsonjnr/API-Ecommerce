package com.eCommerce.dream.dto.subcategories;

import jakarta.validation.constraints.NotBlank;

public class SubcategoriesUpdateDTO {

    @NotBlank(message = "The value cannot be empty or null")
    private String newName;

    public SubcategoriesUpdateDTO() {
    }

    public SubcategoriesUpdateDTO(String newName) {
        this.newName = newName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
