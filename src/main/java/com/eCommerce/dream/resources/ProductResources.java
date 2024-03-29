package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Product;
import com.eCommerce.dream.dto.product.ProductDTO;
import com.eCommerce.dream.dto.product.ProductDetailDTO;
import com.eCommerce.dream.dto.product.ProductNewDTO;
import com.eCommerce.dream.dto.product.ProductUpdateDTO;
import com.eCommerce.dream.repository.CategoryRepository;
import com.eCommerce.dream.repository.ProductRepository;
import com.eCommerce.dream.services.ProductServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ecommerce/product")
public class ProductResources {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository repositoryCat;

    @Autowired
    private ProductServices services;

    @GetMapping(value="/{id}")
    public ResponseEntity<ProductDetailDTO> findById(@PathVariable Long id){
        Optional<Product> product = repository.findById(id);

        return (!product.isEmpty()) ?
                ResponseEntity.ok().body(new ProductDetailDTO(product.get())) :
                ResponseEntity.notFound().build();
    }

    @GetMapping(value="/page")
    public ResponseEntity<Page<ProductDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC" ) String direction) {
        Page<Product> list = services.findPage(page, linesPerPage, orderBy, direction);
        Page<ProductDTO> listDTO = list.map(obj -> new ProductDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductNewDTO newProduct, UriComponentsBuilder uriBuilder){
        Product product = services.save(newProduct);
        URI uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDTO(product));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return repository.findById(id)
                .map(product -> {
                    product.setAvailable(Boolean.FALSE);
                    repository.save(product);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable ("id") Long id, @RequestBody ProductUpdateDTO productUpdateDTO){
        Product updated = services.update(productUpdateDTO, id);
        ProductDetailDTO updatedDTO = new ProductDetailDTO(updated);

        return ResponseEntity.ok().body(updatedDTO);
    }
}
