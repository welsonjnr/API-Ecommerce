package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Address;
import com.eCommerce.dream.domain.Sale;
import com.eCommerce.dream.dto.address.AddressDTO;
import com.eCommerce.dream.dto.address.AddressDetailDTO;
import com.eCommerce.dream.dto.address.NewAddressDTO;
import com.eCommerce.dream.dto.sale.NewSaleDTO;
import com.eCommerce.dream.dto.sale.SaleDTO;
import com.eCommerce.dream.repository.AddressRepository;
import com.eCommerce.dream.services.AddressServices;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ecommerce/address")
public class AddressResources{

    @Autowired
    private AddressRepository repository;

    @Autowired
    private AddressServices services;

    @GetMapping(value="/{id}")
    public ResponseEntity<AddressDetailDTO> findById(@PathVariable Long id) throws ObjectNotFoundException {
        Optional<Address> address = repository.findById(id);

        return (!address.isEmpty()) ?
                ResponseEntity.ok().body(new AddressDetailDTO(address.get())) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AddressDTO> insert(@Valid @RequestBody NewAddressDTO newAddressDTO, UriComponentsBuilder uriBuilder){
        Address address = services.save(newAddressDTO);
        URI uri = uriBuilder.path("/address/{id}").buildAndExpand(address.getId()).toUri();
        return ResponseEntity.created(uri).body(new AddressDTO(address));
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
