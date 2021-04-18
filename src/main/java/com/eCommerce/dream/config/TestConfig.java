
package com.eCommerce.dream.config;

import com.eCommerce.dream.domain.Address;
import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.domain.Country;
import com.eCommerce.dream.domain.User;
import com.eCommerce.dream.repository.AddressRepository;
import com.eCommerce.dream.repository.ClientRepository;
import com.eCommerce.dream.repository.CountryRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eCommerce.dream.repository.UserRepository;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements  CommandLineRunner{

    @Autowired
    private UserRepository repositoryUser;

    @Autowired
    private ClientRepository repositoryCli;
    
    @Autowired
    private AddressRepository repositoryAddr;
    
    @Autowired
    private CountryRepository repositoryCount;

    @Override
    public void run(String... args) throws Exception {
        List<Address> addrs = new ArrayList<>();
        Country country = new Country(null, "Brasil", "BR");
        Address address = new Address(null, "Rua principal", "S/N", "Setor central", "Em frente a loja", "76.160-000", "Goiânia",country);
        Client client = new Client();
        addrs.add(address);
        client.setId(null);
        client.setBirthDate(new LocalDate().toString("dd-MM"));
        client.setCpf("025.258.369-21");
        client.setDescription("Cliente teste");
        client.setName("Teste");
        client.setNickName("Testinho");
        client.setAddress(addrs);
        addrs.get(0).setClient(client);
        repositoryCount.save(country);
        repositoryCli.save(client);
        repositoryAddr.saveAll(addrs);
        User user = new User(null, "user", "user@gmail.com", "password", client);
        repositoryUser.save(user);

    }
}
