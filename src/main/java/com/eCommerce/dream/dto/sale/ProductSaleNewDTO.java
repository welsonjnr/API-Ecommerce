package com.eCommerce.dream.dto.sale;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class ProductSaleNewDTO {

    @NotBlank(message = "The quantity cannot be empty")
    private Integer quantity;
    @NotBlank(message = "The price cannot be empty")
    private BigDecimal price;
    @NotBlank(message = "The product cannot be made without product")
    private Long product;

    public ProductSaleNewDTO() {}

    public ProductSaleNewDTO(Integer quantity, Long product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

}
