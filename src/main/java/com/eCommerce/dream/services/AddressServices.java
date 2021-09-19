package com.eCommerce.dream.services;

import com.eCommerce.dream.domain.*;
import com.eCommerce.dream.dto.address.NewAddressDTO;
import com.eCommerce.dream.dto.sale.NewSaleDTO;
import com.eCommerce.dream.repository.AddressRepository;
import com.eCommerce.dream.repository.ClientRepository;
import com.eCommerce.dream.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServices {

    @Autowired
    private ClientRepository repositoryClient;

    @Autowired
    private AddressRepository repository;

    @Autowired
    private CountryRepository repositoryCountry;

    public Address save(NewAddressDTO address){

        Client client = repositoryClient.findById(address.getIdClient()).get();
        Address newAddress = toAddress(address);
        client.getAddress().add(newAddress);
        newAddress.setClient(client);
        repositoryClient.save(client);
        repository.save(newAddress);

        return newAddress;
    }

    private Address toAddress(NewAddressDTO address){
        Country country = repositoryCountry.findByNameContaining(address.getNameCountry()).get();
        Address newAddress = new Address(null, address.getStreet(), address.getNumber(), address.getSector(), address.getComplement(), address.getCep(), address.getCity(), country);
        return newAddress;
    }

}
