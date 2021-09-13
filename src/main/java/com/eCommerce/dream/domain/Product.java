
package com.eCommerce.dream.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Product {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String shortDescription;
    private String specifications;
    private Integer quantity;
    private Boolean available;
    private String size;
    private String brand;
    private String unity;
    
    @OneToOne(mappedBy = "product")
    private Price price;
    
//    @OneToMany(mappedBy = "product")
//    private List<Images> imgs;

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Category> category;

    public Product() {}

    public Product(Long id, String name, String description, String shortDescription, String specifications, Integer quantity, Boolean available, String size, String brand, String unity, Price price, List<Category> category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.shortDescription = shortDescription;
        this.specifications = specifications;
        this.quantity = quantity;
        this.available = available;
        this.size = size;
        this.brand = brand;
        this.unity = unity;
        this.price = price;
        this.category = category;
    }

    public Product(Long id, String name, String description, Integer quantity, Boolean available, String brand, Price price, List<Category> category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.available = available;
        this.brand = brand;
        this.price = price;
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        return true;
    }
    
}
