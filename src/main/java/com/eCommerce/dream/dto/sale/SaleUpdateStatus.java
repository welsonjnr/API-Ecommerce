package com.eCommerce.dream.dto.sale;

import javax.validation.constraints.NotNull;

public class SaleUpdateStatus {
    @NotNull
    private int newSaleStatus;

    public SaleUpdateStatus() {
    }

    public SaleUpdateStatus(int newSaleStatus) {
        this.newSaleStatus = newSaleStatus;
    }

    public int getNewSaleStatus() {
        return newSaleStatus;
    }

    public void setNewSaleStatus(int newSaleStatus) {
        this.newSaleStatus = newSaleStatus;
    }
}
