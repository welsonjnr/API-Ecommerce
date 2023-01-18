package com.eCommerce.dream.enums;

public enum SaleStatus {

    PENDING(1),
    CONFIRMED(2),
    SEPARATION(3),
    DELIVERED(4),
    CANCELED(5),
    DELETED(6);

    private int valorInteiro;

    SaleStatus(int valorInteiro) {
        this.valorInteiro = valorInteiro;
    }

    public int getValorInteiro() {
        return valorInteiro;
    }

    public void setValorInteiro(int valorInteiro) {
        this.valorInteiro = valorInteiro;
    }
    public static SaleStatus getStatusByInt(int i) {
        for (SaleStatus e : values()) {
            if (e.getValorInteiro() == i) {
                return e;
            }
        }
        return null;
    }

}
