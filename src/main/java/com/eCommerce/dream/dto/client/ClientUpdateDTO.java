package com.eCommerce.dream.dto.client;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ClientUpdateDTO {

    @NotBlank(message = "Customer name cannot be null")
    @Size(min = 4, message = "The customer's name must be at least 4 characters")
    private String nameClient;
    @NotBlank @CPF
    private String cpfClient;
    @NotBlank(message = "Birthday cannot be null")
    private LocalDate birthDateClient;
    private String nickNameClient;
    private String descriptionClient;
    @NotBlank(message = "Phone cannot be null")
    @Size(min = 11, max = 11)
    private String phoneClient;

    public ClientUpdateDTO() {}

    public ClientUpdateDTO(String nameClient, String cpfClient, LocalDate birthDateClient, String nickNameClient, String descriptionClient, String phoneClient) {
        this.nameClient = nameClient;
        this.cpfClient = cpfClient;
        this.birthDateClient = birthDateClient;
        this.nickNameClient = nickNameClient;
        this.descriptionClient = descriptionClient;
        this.phoneClient = phoneClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getCpfClient() {
        return cpfClient;
    }

    public void setCpfClient(String cpfClient) {
        this.cpfClient = cpfClient;
    }

    public LocalDate getBirthDateClient() {
        return birthDateClient;
    }

    public void setBirthDateClient(LocalDate birthDateClient) {
        this.birthDateClient = birthDateClient;
    }

    public String getNickNameClient() {
        return nickNameClient;
    }

    public void setNickNameClient(String nickNameClient) {
        this.nickNameClient = nickNameClient;
    }

    public String getDescriptionClient() {
        return descriptionClient;
    }

    public void setDescriptionClient(String descriptionClient) {
        this.descriptionClient = descriptionClient;
    }

    public String getPhoneClient() {
        return phoneClient;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
    }
}
