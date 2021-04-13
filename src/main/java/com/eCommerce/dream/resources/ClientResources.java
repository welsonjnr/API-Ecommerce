
package com.eCommerce.dream.resources;


import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.dto.ClientDetailDTO;
import com.eCommerce.dream.repository.ClientRepository;
import com.eCommerce.dream.services.ClientService;
import java.util.Optional;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ecommerce/client")
public class ClientResources {
    
    @Autowired
    ClientRepository repository;
    
    @GetMapping(value="/{id}")
    public ResponseEntity<ClientDetailDTO> findById(@PathVariable Long id) throws ObjectNotFoundException{
        Optional<Client> client = repository.findById(id);
        ClientDetailDTO clientDTO = new ClientDetailDTO(client.get());
           return (clientDTO != null) ? 
           ResponseEntity.ok().body(clientDTO) :
           ResponseEntity.notFound().build();
    }
    
}
