package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.domain.User;
import com.eCommerce.dream.dto.client.ClientDTO;
import com.eCommerce.dream.dto.client.ClientNewDTO;
import com.eCommerce.dream.dto.user.UserDTO;
import com.eCommerce.dream.dto.user.UserNewDTO;
import com.eCommerce.dream.repository.UserRepository;
import com.eCommerce.dream.services.UserServices;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value="/ecommerce/user")
public class UserResources {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserServices services;

    @PostMapping (value = "/register")
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserNewDTO newUser, UriComponentsBuilder uriBuilder){
        User user = services.save(newUser);
        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDTO(user));
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) throws ObjectNotFoundException {
        Optional<User> user = repository.findById(id);
        return (!user.isEmpty()) ?
                ResponseEntity.ok().body(user.get()) :
                ResponseEntity.notFound().build();
        }
}
