package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Sale;
import com.eCommerce.dream.dto.sale.NewSaleDTO;
import com.eCommerce.dream.dto.sale.SaleDTO;
import com.eCommerce.dream.repository.SaleRepository;
import com.eCommerce.dream.services.SaleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ecommerce/sale")
public class SaleResources {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SaleServices services;

    @PostMapping
    public ResponseEntity<SaleDTO> insert(@Valid @RequestBody List<NewSaleDTO> newSaleDto, UriComponentsBuilder uriBuilder){
        Sale sale = services.save(newSaleDto);
        URI uri = uriBuilder.path("/sale/{id}").buildAndExpand(sale.getId()).toUri();
        return ResponseEntity.created(uri).body(new SaleDTO(sale));
    }

}
