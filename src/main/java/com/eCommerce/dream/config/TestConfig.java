
package com.eCommerce.dream.config;

import com.eCommerce.dream.domain.Address;
import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.domain.Country;
import com.eCommerce.dream.repository.AddressRepository;
import com.eCommerce.dream.repository.ClientRepository;
import com.eCommerce.dream.repository.CountryRepository;
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
    private ClientRepository repositoryCli;
    
    @Autowired
    private AddressRepository repositoryAddr;
    
    @Autowired
    private CountryRepository repositoryCount;
    
    @Override
    public void run(String... args) throws Exception {
         
    }
}
