package com.eCommerce.dream.dto.client;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class ClientNewDTO {

    //Client
    @NotBlank(message = "Customer name cannot be null")
    @Size(min = 4, message = "The customer's name must be at least 4 characters")
    private String nameClient;
    @NotBlank @CPF
    private String cpf;
    @Min(value = 1, message = "The day of Birthday cannot be null")
    @Max(value = 31, message = "The days cannot be more than 31 days")
    private int dayOfBirthDate;
    @Min(value = 1, message = "The month of Birthday cannot be null")
    @Max(value = 12, message = "The month cannot be more than 12 months")
    private int monthOfBirthDate;
    @Min(value = 1930, message = "The year of Birthday cannot be null")
    private int yearOfBirthDate;

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

    public int getDayOfBirthDate() {
        return dayOfBirthDate;
    }

    public void setDayOfBirthDate(int dayOfBirthDate) {
        this.dayOfBirthDate = dayOfBirthDate;
    }

    public int getMonthOfBirthDate() {
        return monthOfBirthDate;
    }

    public void setMonthOfBirthDate(int monthOfBirthDate) {
        this.monthOfBirthDate = monthOfBirthDate;
    }

    public int getYearOfBirthDate() {
        return yearOfBirthDate;
    }

    public void setYearOfBirthDate(int yearOfBirthDate) {
        this.yearOfBirthDate = yearOfBirthDate;
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
