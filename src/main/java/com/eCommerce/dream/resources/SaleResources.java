package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Sale;
import com.eCommerce.dream.dto.sale.NewSaleDTO;
import com.eCommerce.dream.dto.sale.SaleDTO;
import com.eCommerce.dream.dto.sale.SaleDetailDTO;
import com.eCommerce.dream.dto.sale.SaleUpdateStatus;
import com.eCommerce.dream.enums.SaleStatus;
import com.eCommerce.dream.repository.ProductSaleRepository;
import com.eCommerce.dream.repository.SaleRepository;
import com.eCommerce.dream.services.SaleServices;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ecommerce/sale")
public class SaleResources {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private ProductSaleRepository productSaleRepository;

    @Autowired
    private SaleServices services;

    @GetMapping(value="/{id}")
    public ResponseEntity<SaleDetailDTO> findById(@PathVariable Long id) throws ObjectNotFoundException{
        Optional<Sale> sale = repository.findById(id);
        return (!sale.isEmpty()) ?
                ResponseEntity.ok().body(new SaleDetailDTO(sale.get(), productSaleRepository)) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/client/{client}")
    public ResponseEntity<List<SaleDTO>> findByNameClient(@PathVariable String client) throws ObjectNotFoundException{
        List<SaleDTO> salesDTO = new ArrayList<>();
        services.findSaleByNameClient(client).forEach(sale -> salesDTO.add(new SaleDTO(sale)));

        return (!salesDTO.isEmpty()) ?
                ResponseEntity.ok().body(salesDTO) :
                ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<SaleDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "dataSale") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC" ) String direction){
        Page<Sale> list = services.findPage(page, linesPerPage, orderBy, direction);
        Page<SaleDTO> listDTO = list.map(obj -> new SaleDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<SaleDetailDTO> insert(@Valid @RequestBody NewSaleDTO newSaleDto, UriComponentsBuilder uriBuilder){
        Sale sale = services.save(newSaleDto);
        URI uri = uriBuilder.path("/sale/{id}").buildAndExpand(sale.getId()).toUri();
        return ResponseEntity.created(uri).body(new SaleDetailDTO(sale));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return repository.findById(id)
                .map(sale -> {
                    sale.setSaleStatus(SaleStatus.DELETED);
                    repository.save(sale);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/updateStatus/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody SaleUpdateStatus statusInt){
        return repository.findById(id)
                .map(sale -> {
                    sale.setSaleStatus(SaleStatus.getStatusByInt(statusInt.getNewSaleStatus()));
                    return ResponseEntity.ok().body(new SaleDetailDTO(repository.save(sale)));
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody NewSaleDTO newSaleDto, UriComponentsBuilder uriBuilder){
        Sale sale = services.update(id, newSaleDto);
        URI uri = uriBuilder.path("/sale/{id}").buildAndExpand(sale.getId()).toUri();
        return ResponseEntity.created(uri).body(new SaleDetailDTO(sale));
    }
}
