
package com.eCommerce.dream.dto.client;

import com.eCommerce.dream.domain.Address;
import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.dto.address.AddressDetailDTO;
import java.lang.String;

import java.util.List;
import java.util.stream.Collectors;

public class ClientDetailDTO {
    
    private Long id;
    private String nameClient;
    private String cpf;
    private String birthDate;
    private String nickName;
    private String description;
    private String phone;
    private List<AddressDetailDTO> addressDTO;

    public ClientDetailDTO() {}

    public ClientDetailDTO(Client client){
        this.id = client.getId();
        this.nameClient = client.getName();
        this.cpf = client.getCpf();
        this.birthDate = client.getBirthDate();
        this.nickName = client.getNickName();
        this.description = client.getDescription();
        this.phone = client.getPhone();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    public List<AddressDetailDTO> getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(List<AddressDetailDTO> addressDTO) {
        this.addressDTO = addressDTO;
    }

    public List<AddressDetailDTO> converterAddress(List<Address> address){
        List<AddressDetailDTO> listDTO = address.stream().map(AddressDetailDTO::new).collect(Collectors.toList());
        return listDTO;
    }
}
