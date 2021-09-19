package com.eCommerce.dream.dto.address;

import com.eCommerce.dream.domain.Address;

public class AddressDTO {

    private Long id;
    private String street;
    private String number;
    private String sector;
    private String complement;
    private String cep;
    private String city;
    private String country;

    public AddressDTO() {}

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.sector = address.getSector();
        this.complement = address.getComplement();
        this.cep = address.getCep();
        this.city = address.getCity();
        this.country = address.getCountry().getAbbreviation();
    }

    public AddressDTO(String street, String number, String sector, String complement, String cep, String city) {
        this.street = street;
        this.number = number;
        this.sector = sector;
        this.complement = complement;
        this.cep = cep;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
