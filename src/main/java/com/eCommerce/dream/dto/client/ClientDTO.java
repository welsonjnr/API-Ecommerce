package com.eCommerce.dream.dto.client;

import com.eCommerce.dream.domain.Address;
import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.dto.address.AddressDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ClientDTO {

    private Long id;
    private String nameClient;
    private String nickname;
    private String cpf;
    private Integer addresses;
    private List<AddressDTO> addressDTO;

    public ClientDTO() {}

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.nameClient = client.getName();
        this.nickname = client.getNickName();
        this.cpf = client.getCpf();
        this.addresses = client.getAddress().size();
        this.addressDTO = converterAddress(client.getAddress());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getAddresses() {
        return addresses;
    }

    public void setAddresses(Integer addresses) {
        this.addresses = addresses;
    }

    public List<AddressDTO> getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(List<AddressDTO> addressDTO) {
        this.addressDTO = addressDTO;
    }

    public List<AddressDTO> converterAddress(List<Address> address){
        List<AddressDTO> listDTO = address.stream().map(AddressDTO::new).collect(Collectors.toList());
        return listDTO;
    }
}
