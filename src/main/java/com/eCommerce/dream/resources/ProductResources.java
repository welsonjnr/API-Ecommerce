package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.domain.Product;
import com.eCommerce.dream.dto.client.ClientDTO;
import com.eCommerce.dream.dto.client.ClientDetailDTO;
import com.eCommerce.dream.dto.client.ClientNewDTO;
import com.eCommerce.dream.dto.product.ProductDTO;
import com.eCommerce.dream.dto.product.ProductDetailDTO;
import com.eCommerce.dream.dto.product.ProductNewDTO;
import com.eCommerce.dream.repository.ProductRepository;
import com.eCommerce.dream.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ecommerce/product")
public class ProductResources {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductServices services;

    @GetMapping(value="/{id}")
    public ResponseEntity<ProductDetailDTO> findById(@PathVariable Long id){
        Optional<Product> product = repository.findById(id);
        ProductDetailDTO productDTO = new ProductDetailDTO(product.get());

        return (productDTO != null) ?
                ResponseEntity.ok().body(productDTO) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductNewDTO newProduct, UriComponentsBuilder uriBuilder){
        Product product = services.save(newProduct);
        URI uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDTO(product));
    }

}
