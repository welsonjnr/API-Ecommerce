package com.eCommerce.dream.dto.category;

import com.eCommerce.dream.domain.Category;
import com.eCommerce.dream.domain.Product;
import com.eCommerce.dream.domain.Subcategories;

import java.util.List;

public class CategoryDetailDTO {

    private Long id;
    private String name;
    private Integer totalProducts;
    private Integer totalSubcategories;
    private List<Product> products;
    private List<Subcategories> subcategories;

    public CategoryDetailDTO(){}

    public CategoryDetailDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.totalProducts = category.getProduct().size();
        this.totalSubcategories = category.getSubcategories().size();
        this.products = category.getProduct();
        this.subcategories = category.getSubcategories();
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Subcategories> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategories> subcategories) {
        this.subcategories = subcategories;
    }
}
