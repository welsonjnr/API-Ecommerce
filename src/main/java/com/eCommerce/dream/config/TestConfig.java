
package com.eCommerce.dream.config;

import com.eCommerce.dream.domain.*;
import com.eCommerce.dream.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.eCommerce.dream.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements  CommandLineRunner{

    @Autowired
    private UserServices serviceUser;

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

    @Autowired
    private ProductRepository repositoryProd;

    @Autowired
    private PriceRepository repositoryPrice;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = repositoryCate.save(new Category( null ,"Comida"));
        Category category2 = repositoryCate.save(new Category( null ,"Brinquedo"));

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


        Role role1 = new Role(null, "ROLE_USER");
        Role role2 = new Role(null, "ROLE_MANAGER");
        Role role3 = new Role(null, "ROLE_ADMIN");
        serviceUser.saveRole(role1);
        serviceUser.saveRole(role2);
        serviceUser.saveRole(role3);
        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);
        roles.add(role3);

        Price price = new Price(18.99, 20.90);
        repositoryPrice.save(price);

        Product product = new Product();

        product.setId(null);
        product.setName("Burguer Bacon");
        product.setDescription("Burguer Bacon, com dois hamburgures, dois bacons, pao e cebola.");
        product.setShortDescription("O burguer bancon eo mais pedido");
        product.setSpecifications("Nenhuma especificacao");
        product.setQuantity(2);
        product.setAvailable(true);
        product.setSize("Familia");
        product.setBrand("Paulao Burguer");
        product.setUnity("Uma unidade");
        product.setPrice(price);
        product.setCategory(repositoryCate.findById(1L).get());

        Product product2 = new Product();

        product2.setId(null);
        product2.setName("Jordan Duplo");
        product2.setDescription("Burguer Bacon, com dois hamburgures, dois bacons, pao e cebola.");
        product2.setShortDescription("O burguer bancon eo mais pedido");
        product2.setSpecifications("Nenhuma especificacao");
        product2.setQuantity(2);
        product2.setAvailable(true);
        product2.setSize("Familia");
        product2.setBrand("Paulao Burguer");
        product2.setUnity("Uma unidade");
        product2.setPrice(price);
        product2.setCategory(repositoryCate.findById(1L).get());

        repositoryProd.save(product);
        repositoryProd.save(product2);

        serviceUser.saveUser(new User(null, "usuario", "usuario@gmail.com","1234", roles));

    }
}
