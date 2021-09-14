package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Address;
import com.eCommerce.dream.dto.address.AddressDTO;
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
    private AddressRepository repository;

    @GetMapping(value="/{id}")
    public ResponseEntity<AddressDetailDTO> findById(@PathVariable Long id) throws ObjectNotFoundException {
        Optional<Address> address = repository.findById(id);
        AddressDetailDTO addressDTO = new AddressDetailDTO(address.get());

        return (addressDTO != null) ?
                ResponseEntity.ok().body(addressDTO) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return repository.findById(id)
                .map(address -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable ("id") Long id, @RequestBody AddressDTO addressToUpdate){
        return repository.findById(id)
                .map(address -> {
                    address.setStreet(addressToUpdate.getStreet());
                    address.setNumber(addressToUpdate.getNumber());
                    address.setSector(addressToUpdate.getSector());
                    address.setComplement(addressToUpdate.getComplement());
                    address.setCep(addressToUpdate.getCep());
                    address.setCity(addressToUpdate.getCity());
                    Address updated = repository.save(address);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

}
