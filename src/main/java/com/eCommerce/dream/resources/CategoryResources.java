package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Category;
import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.dto.category.CategoryDTO;
import com.eCommerce.dream.dto.category.CategoryDetailDTO;
import com.eCommerce.dream.dto.category.CategoryNewDTO;
import com.eCommerce.dream.dto.client.ClientDTO;
import com.eCommerce.dream.dto.client.ClientNewDTO;
import com.eCommerce.dream.repository.CategoryRepository;
import com.eCommerce.dream.services.CategoryServices;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value="/ecommerce/categorys")
public class CategoryResources {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private CategoryServices services;

    @GetMapping(value="/{id}")
    public ResponseEntity<CategoryDetailDTO> findById(@PathVariable Long id) throws ObjectNotFoundException {
        Optional<Category> caterory = repository.findById(id);
        CategoryDetailDTO categoryDetailDTO = new CategoryDetailDTO(caterory.get());

        return (categoryDetailDTO != null) ?
                ResponseEntity.ok().body(categoryDetailDTO) :
                ResponseEntity.notFound().build();
    }

    @GetMapping(value="/page")
    public ResponseEntity<Page<CategoryDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC" ) String direction) {
        Page<Category> list = services.findPage(page, linesPerPage, orderBy, direction);
        Page<CategoryDTO> listDTO = list.map(obj -> new CategoryDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@Valid @RequestBody CategoryNewDTO newCategory, UriComponentsBuilder uriBuilder){
        Category category = services.save(newCategory);
        URI uri = uriBuilder.path("/categorys/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoryDTO(category));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return repository.findById(id)
                .map(category -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable ("id") Long id, @RequestBody CategoryNewDTO categoryToUpdate){
        return repository.findById(id)
                .map(category -> {
                    category.setName(categoryToUpdate.getName());
                    Category updated = repository.save(category);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
