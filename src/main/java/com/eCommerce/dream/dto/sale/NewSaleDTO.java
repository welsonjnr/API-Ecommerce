package com.eCommerce.dream.dto.sale;

import com.eCommerce.dream.domain.ProductSale;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.Double;
import java.util.List;

public class NewSaleDTO {

    //Client
    @NotNull(message = "Customer id cannot be Null or Empty")
    private Long idClient;
    @NotEmpty(message = "Customer name cannot be Null or Empty")
    private String nameClient;
    @NotBlank @CPF
    private String cpf;

    //Products
    @NotNull
    private List<ProductSaleDTO> products;

    public NewSaleDTO() {}

    public NewSaleDTO(Long idClient, String nameClient, String cpf, List<ProductSaleDTO> products) {
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.cpf = cpf;
        this.products = products;
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

    public List<ProductSaleDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSaleDTO> products) {
        this.products = products;
    }
}
