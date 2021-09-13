package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Category;
import com.eCommerce.dream.domain.Sale;
import com.eCommerce.dream.dto.sale.NewSaleDTO;
import com.eCommerce.dream.dto.sale.SaleDTO;
import com.eCommerce.dream.dto.sale.SaleDetailDTO;
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
        SaleDetailDTO saleDetailDTO = new SaleDetailDTO(sale.get(), productSaleRepository);

        return (saleDetailDTO != null) ?
                ResponseEntity.ok().body(saleDetailDTO) :
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
    public ResponseEntity<SaleDTO> insert(@Valid @RequestBody NewSaleDTO newSaleDto, UriComponentsBuilder uriBuilder){
        Sale sale = services.save(newSaleDto);
        URI uri = uriBuilder.path("/sale/{id}").buildAndExpand(sale.getId()).toUri();
        return ResponseEntity.created(uri).body(new SaleDTO(sale));
    }
}
