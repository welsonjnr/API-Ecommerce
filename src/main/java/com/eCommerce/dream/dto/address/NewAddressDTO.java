package com.eCommerce.dream.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class NewAddressDTO {

    //Client
    @NotNull(message = "Customer id cannot be Null or Empty")
    private Long idClient;
    @NotEmpty(message = "Customer name cannot be Null or Empty")
    private String nameClient;
    @NotBlank
    @CPF
    private String cpf;

    //Address
    @NotBlank(message = "Address street cannot be null")
    private String street;
    @NotBlank(message = "Address number cannot be null")
    private String number;
    @NotBlank(message = "Address sector cannot be null")
    private String sector;
    @NotBlank(message = "Address complement cannot be null")
    private String complement;
    @NotBlank(message = "Cep cannot be null")
    private String cep;
    @NotBlank(message = "City cannot be null")
    private String city;
    @NotBlank(message = "Country cannot be null")
    private String nameCountry;

    public NewAddressDTO() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }
}
