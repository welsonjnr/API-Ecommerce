package com.eCommerce.dream.dto.client;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class ClientNewDTO {

    //Client
    @NotBlank(message = "Customer name cannot be null")
    @Size(min = 4, message = "The customer's name must be at least 4 characters")
    private String nameClient;
    @NotBlank @CPF
    private String cpf;
    @NotBlank(message = "Birthday cannot be null")
    private LocalDate birthDate;
    private String nickName;
    private String description;
    @NotBlank(message = "Phone cannot be null")
    @Size(min = 11, max = 11)
    private String phone;

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

    public ClientNewDTO(){}

    public ClientNewDTO(String nameClient, String cpf, LocalDate birthDate, String nickName, String description, String street,
                        String number, String sector, String complement, String cep, String city, String nameCountry) {
        this.nameClient = nameClient;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.nickName = nickName;
        this.description = description;
        this.street = street;
        this.number = number;
        this.sector = sector;
        this.complement = complement;
        this.cep = cep;
        this.city = city;
        this.nameCountry = nameCountry;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
