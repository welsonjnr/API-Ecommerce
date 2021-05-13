package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Product;
import com.eCommerce.dream.domain.Sale;
import com.eCommerce.dream.dto.product.ProductDTO;
import com.eCommerce.dream.dto.product.ProductNewDTO;
import com.eCommerce.dream.dto.sale.SaleDTO;
import com.eCommerce.dream.dto.sale.SaleNewDTO;
import com.eCommerce.dream.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/ecommerce/sale")
public class SaleResources {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SaleService services;

    @PostMapping
    public ResponseEntity<SaleNewDTO> insert(@Valid @RequestBody SaleNewDTO newSale, UriComponentsBuilder uriBuilder){
        Sale sale = services.save(newSale);
        URI uri = uriBuilder.path("/sale/{id}").buildAndExpand(sale.getId()).toUri();
        return ResponseEntity.created(uri).body(new SaleDTO(sale));
    }

}
