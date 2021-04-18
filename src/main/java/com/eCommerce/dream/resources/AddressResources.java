package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Address;
import com.eCommerce.dream.dto.address.AddressDetailDTO;
import com.eCommerce.dream.repository.AddressRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/ecommerce/address")
public class AddressResources{

    @Autowired
    AddressRepository repository;

    @GetMapping(value="/{id}")
    public ResponseEntity<AddressDetailDTO> findById(@PathVariable Long id) throws ObjectNotFoundException {
        Optional<Address> address = repository.findById(id);
        AddressDetailDTO addressDTO = new AddressDetailDTO(address.get());

        return (addressDTO != null) ?
                ResponseEntity.ok().body(addressDTO) :
                ResponseEntity.notFound().build();
    }
}
