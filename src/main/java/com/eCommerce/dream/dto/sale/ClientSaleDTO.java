package com.eCommerce.dream.dto.sale;

import javax.validation.constraints.NotBlank;

public class ClientSaleDTO {

    @NotBlank(message = "Customer id cannot be Null or Empty")
    private Long idClient;
    @NotBlank(message = "Customer name cannot be Null or Empty")
    private String nameClient;
    @NotBlank(message = "Customer nickName cannot be Null or Empty")
    private String nickName;

    public ClientSaleDTO(Long idClient, String nameClient, String nickName) {
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.nickName = nickName;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
