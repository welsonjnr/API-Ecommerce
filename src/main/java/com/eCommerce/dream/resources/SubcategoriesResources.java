package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Category;
import com.eCommerce.dream.domain.Subcategories;
import com.eCommerce.dream.dto.category.CategoryDTO;
import com.eCommerce.dream.dto.category.CategoryDetailDTO;
import com.eCommerce.dream.dto.category.CategoryNewDTO;
import com.eCommerce.dream.dto.subcategories.SubcategoriesDTO;
import com.eCommerce.dream.dto.subcategories.SubcategoriesUpdateDTO;
import com.eCommerce.dream.repository.SubcategoriesRepository;
import com.eCommerce.dream.services.SubcategoriesServices;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value="/ecommerce/subcategories")
public class SubcategoriesResources {

    @Autowired
    private SubcategoriesRepository repository;

    @Autowired
    private SubcategoriesServices services;

    @GetMapping(value="/{id}")
    public ResponseEntity<SubcategoriesDTO> findById(@PathVariable Long id) throws ObjectNotFoundException {
        Optional<Subcategories> subcategories = repository.findById(id);
        SubcategoriesDTO subcategoriesDTO = new SubcategoriesDTO(subcategories.get());

        return (subcategoriesDTO != null) ?
                ResponseEntity.ok().body(subcategoriesDTO) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SubcategoriesDTO> insert(@Valid @RequestBody SubcategoriesDTO newSubcategories, UriComponentsBuilder uriBuilder){
        Subcategories subcategories = services.save(newSubcategories);
        URI uri = uriBuilder.path("/subcategories/{id}").buildAndExpand(subcategories.getId()).toUri();
        return ResponseEntity.created(uri).body(new SubcategoriesDTO(subcategories));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return repository.findById(id)
                .map(subcategories -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable ("id") Long id, @RequestBody SubcategoriesUpdateDTO subcategoriesToUpdate){
        return repository.findById(id)
                .map(subcategories -> {
                    subcategories.setName(subcategoriesToUpdate.getNewName());
                    Subcategories updated = repository.save(subcategories);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
