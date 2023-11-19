
package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.dto.client.ClientDTO;
import com.eCommerce.dream.dto.client.ClientDetailDTO;
import com.eCommerce.dream.dto.client.ClientNewDTO;
import com.eCommerce.dream.dto.client.ClientUpdateDTO;
import com.eCommerce.dream.repository.ClientRepository;

import java.net.URI;
import java.util.Optional;

import com.eCommerce.dream.services.ClientServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value="/ecommerce/client")
public class ClientResources {
    
    @Autowired
    ClientRepository repository;

    @Autowired
    ClientServices services;
    
    @GetMapping(value="/{id}")
    public ResponseEntity<ClientDetailDTO> findById(@PathVariable Long id) {
        Optional<Client> client = repository.findById(id);

           return (!client.isEmpty()) ?
           ResponseEntity.ok().body(new ClientDetailDTO(client.get())) :
           ResponseEntity.notFound().build();
    }

    @GetMapping(value="/page")
    public ResponseEntity<Page<ClientDTO>> findPage(
                                                 @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                 @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                 @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                                 @RequestParam(value = "direction", defaultValue = "ASC" ) String direction) {
        Page<Client> list = services.findPage(page, linesPerPage, orderBy, direction);
        Page<ClientDTO> listDTO = list.map(obj -> new ClientDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientNewDTO newClient, UriComponentsBuilder uriBuilder){
        Client client = services.save(newClient);
        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientDTO(client));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return repository.findById(id)
                .map(client -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable ("id") Long id, @RequestBody ClientUpdateDTO clientToUpdate){
        return repository.findById(id)
                .map(client -> {
                    client.setName(clientToUpdate.getNameClient());
                    client.setCpf(clientToUpdate.getCpfClient());
                    client.setNickName(clientToUpdate.getNickNameClient());
                    client.setBirthDate(clientToUpdate.getBirthDateClient());
                    client.setPhone(clientToUpdate.getPhoneClient());
                    client.setDescription(clientToUpdate.getDescriptionClient());
                    Client updated = repository.save(client);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
