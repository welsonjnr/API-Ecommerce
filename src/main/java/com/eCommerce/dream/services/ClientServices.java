package com.eCommerce.dream.services;

import com.eCommerce.dream.domain.Address;
import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.domain.Country;
import com.eCommerce.dream.dto.client.ClientNewDTO;
import com.eCommerce.dream.repository.AddressRepository;
import com.eCommerce.dream.repository.ClientRepository;
import com.eCommerce.dream.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientServices {

    @Autowired
    private CountryRepository repositoryCountry;

    @Autowired
    private ClientRepository repositoryClient;

    @Autowired
    private AddressRepository repositoryAddress;

    public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repositoryClient.findAll(pageRequest);
    }

    public Client byDTO(ClientNewDTO objDto){
        List<Address> addresses = new ArrayList<>();
        Country country = repositoryCountry.findByNameContaining(objDto.getNameCountry()).get();
        Address address = new Address(null, objDto.getStreet(), objDto.getNumber(), objDto.getSector(), objDto.getComplement(), objDto.getCep(), objDto.getCity(), country);
        addresses.add(address);
        Client client = new Client(null, objDto.getNameClient(), objDto.getCpf(), objDto.getBirthDate(), objDto.getNickName(), objDto.getDescription(), addresses);
        addresses.get(0).setClient(client);
        repositoryClient.save(client);
        repositoryAddress.save(address);
        return client;
    }

    public Client save(ClientNewDTO objDto){
        List<Address> addresses = new ArrayList<>();
        Country country = repositoryCountry.findByNameContaining(objDto.getNameCountry()).get();
        Address address = new Address(null, objDto.getStreet(), objDto.getNumber(), objDto.getSector(), objDto.getComplement(), objDto.getCep(), objDto.getCity(), country);
        addresses.add(address);
        Client client = new Client(null, objDto.getNameClient(), objDto.getCpf(), objDto.getBirthDate(), objDto.getNickName(), objDto.getDescription(), addresses);
        addresses.get(0).setClient(client);
        repositoryClient.save(client);
        repositoryAddress.save(address);
        return client;
    }
}
