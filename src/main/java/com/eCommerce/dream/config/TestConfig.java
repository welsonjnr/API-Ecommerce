
package com.eCommerce.dream.config;

import com.eCommerce.dream.domain.*;
import com.eCommerce.dream.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private CategoryRepository repositoryCate;

    @Override
    public void run(String... args) throws Exception {

        repositoryCate.save(new Category( null ,"Comida"));
        repositoryCate.save(new Category( null ,"Brinquedo"));

        List<Address> addrs = new ArrayList<>();
        Country country = new Country(null, "Brasil", "BR");
        Address address = new Address(null, "Rua principal", "S/N", "Setor central", "Em frente a loja", "76.160-000", "Goiânia",country);
        Address address1 = new Address(null, "Rua principal", "S/N", "Setor central", "Em frente a loja", "76.160-000", "Goiânia",country);
        Address address2 = new Address(null, "Rua principal", "S/N", "Setor central", "Em frente a loja", "76.160-000", "Goiânia",country);
        Address address3 = new Address(null, "Rua principal", "S/N", "Setor central", "Em frente a loja", "76.160-000", "Goiânia",country);
        Client client = new Client();
        addrs.add(address);
        addrs.add(address1);
        addrs.add(address2);
        addrs.add(address3);
        client.setId(null);
        client.setBirthDate(LocalDate.of(1998, 8, 15));
        client.setCpf("025.258.369-21");
        client.setDescription("Cliente teste");
        client.setName("Teste");
        client.setNickName("Testinho");
        client.setPhone("(64) 9 9203-2565");
        client.setAddress(addrs);
        addrs.stream().forEach( adr -> adr.setClient(client));
        repositoryCount.save(country);
        repositoryCli.save(client);
        repositoryAddr.saveAll(addrs);
        User user = new User(null, "user", "user@gmail.com", "password", client);
        repositoryUser.save(user);

    }
}
