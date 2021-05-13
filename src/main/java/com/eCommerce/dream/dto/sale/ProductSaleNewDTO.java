package com.eCommerce.dream.dto.sale;

import com.eCommerce.dream.domain.Client;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class ProductSaleNewDTO {

    @NotBlank(message = "The quantity cannot be empty")
    private Integer quantity;
    private BigDecimal amountSale;
    @NotBlank(message = "The sale cannot be made without product")
    private Long product;

    public ProductSaleNewDTO() {}

    public ProductSaleNewDTO(Integer quantity, BigDecimal amountSale, Long product) {
        this.quantity = quantity;
        this.amountSale = amountSale;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmountSale() {
        return amountSale;
    }

    public void setAmountSale(BigDecimal amountSale) {
        this.amountSale = amountSale;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

}
