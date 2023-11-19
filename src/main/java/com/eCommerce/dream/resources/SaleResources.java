package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.domain.Product;
import com.eCommerce.dream.domain.ProductSale;
import com.eCommerce.dream.domain.Sale;
import com.eCommerce.dream.dto.sale.*;
import com.eCommerce.dream.enums.SaleStatus;
import com.eCommerce.dream.repository.ClientRepository;
import com.eCommerce.dream.repository.ProductRepository;
import com.eCommerce.dream.repository.ProductSaleRepository;
import com.eCommerce.dream.repository.SaleRepository;
import com.eCommerce.dream.services.SaleServices;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
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
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;

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
    public ResponseEntity<List<SaleDTO>> findByNameClient(@PathVariable Client client) throws ObjectNotFoundException{
        List<SaleDTO> salesDTO = new ArrayList<>();
        services.findClientForId(client.getId()).forEach(sale -> salesDTO.add(new SaleDTO(sale)));

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

    public Sale update(Long id, NewSaleDTO updateSaleDto) {
        //FIXME POR FAVOR EU ESTOU QUERENDO ENTREGAR LOGO, MAS ME CONSERTE POR FAVOR.
        Sale newSale = repository.findById(id).get();
        newSale.getProductSalesId().forEach(x -> x.setSale(null));
        //Products
        List<ProductSale> productsForSale = new LinkedList<>();
        updateSaleDto.getProducts().forEach(prod -> productsForSale.add(converterToProductSale(prod)));

        Client client = clientRepository.findById(updateSaleDto.getIdClient()).get();

        newSale = converterToSale(productsForSale, client);
        newSale.setClient(client);
        newSale.setId(id);
        repository.save(newSale);
        Sale finalNewSale = newSale;
        productsForSale.forEach(productSale -> productSale.setSale(finalNewSale));
        productsForSale.forEach(prod -> productSaleRepository.save(prod));
        return newSale;
    }

    private ProductSale converterToProductSale(ProductSaleDTO objDto){

        Product product = productRepository.findById(objDto.getIdProduct()).get();
        Double amount = objDto.getPriceSale() * objDto.getQuantity();

        ProductSale productSale = new ProductSale(null, objDto.getQuantity(), objDto.getPriceSale(), amount, objDto.getInfo(),product);
        return productSale;
    }

    private Sale converterToSale(List<ProductSale> productsForSale, Client client){
        Double amount = productsForSale.stream().mapToDouble(prod -> prod.getAmountSaleProduct().doubleValue()).sum();
        Sale sale = new Sale(null, amount, LocalDateTime.now(), SaleStatus.PENDING, client, productsForSale);
        return sale;
    }
}