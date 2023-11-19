package com.eCommerce.dream.dto.sale;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductSaleDTO {

    //Info
    @NotNull(message = "The quantity of product cannot be Null or Empty")
    private Integer quantity;

    //Product
    @NotNull(message = "Product id cannot be Null or Empty")
    private Long idProduct;
    @NotBlank(message = "Name product cannot be Null or Empty")
    private String nameProduct;
    @NotNull(message = "PriceSale of product cannot be Null or Empty")
    private Double priceSale;
    private String info;

    public ProductSaleDTO() {}

    public ProductSaleDTO(Integer quantity, Long idProduct, String nameProduct, Double priceSale) {
        this.quantity = quantity;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceSale = priceSale;
    }

    public ProductSaleDTO(Integer quantity, Long idProduct, String nameProduct, Double priceSale, String info) {
        this.quantity = quantity;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceSale = priceSale;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(Double priceSale) {
        this.priceSale = priceSale;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
