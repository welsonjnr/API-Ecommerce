
package com.eCommerce.dream.dto;

import com.eCommerce.dream.domain.Address;
import com.eCommerce.dream.domain.Client;
import java.util.Date;
import java.util.List;

public class ClientDetailDTO {
    
    private Long id;
    private String nameClient;
    private String cpf;
    private Date birthDate;
    private String nickName;
    private String description;
    
    private List<Address> address;


    public ClientDetailDTO() {}

    public ClientDetailDTO(Client client){
        this.id = client.getId();
        this.nameClient = client.getName();
        this.cpf = client.getCpf();
        this.birthDate = client.getBirthDate();
        this.nickName = client.getNickName();
        this.description = client.getDescription();
        this.address = client.getAddress();
          
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
  
}
