package com.eCommerce.dream.services;

import com.eCommerce.dream.domain.*;
import com.eCommerce.dream.dto.sale.NewSaleDTO;
import com.eCommerce.dream.dto.sale.ProductSaleDTO;
import com.eCommerce.dream.enums.SaleStatus;
import com.eCommerce.dream.repository.ClientRepository;
import com.eCommerce.dream.repository.ProductRepository;
import com.eCommerce.dream.repository.ProductSaleRepository;
import com.eCommerce.dream.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.Double;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class SaleServices {

    @Autowired
    private ProductSaleRepository repositoryProductSale;

    @Autowired
    private ProductRepository repositoryProduct;

    @Autowired
    private SaleRepository repository;


    public Page<Sale> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Sale save(NewSaleDTO sale){

        //Products
        List<ProductSale> productsForSale = new LinkedList<>();
        sale.getProducts().forEach(prod -> productsForSale.add(converterToProductSale(prod)));

        String clientForSale = sale.getNameClient();

        Sale newSale = converterToSale(productsForSale, clientForSale);
        newSale.setClient(clientForSale);
        repository.save(newSale);
        productsForSale.forEach(productSale -> productSale.setSale(newSale));
        productsForSale.forEach(prod -> repositoryProductSale.save(prod));
        return newSale;
    }

    private ProductSale converterToProductSale(ProductSaleDTO objDto){

        Product product = repositoryProduct.findById(objDto.getIdProduct()).get();
        Double amount = objDto.getPriceSale() * objDto.getQuantity();

        ProductSale productSale = new ProductSale(null, objDto.getQuantity(), objDto.getPriceSale(), amount, product);
        return productSale;
    }

    private Sale converterToSale(List<ProductSale> productsForSale, String client){
        Double amount = productsForSale.stream().mapToDouble(prod -> prod.getAmountSaleProduct().longValue()).sum();
        Sale sale = new Sale(null, amount, LocalDateTime.now(), SaleStatus.PENDING, client, productsForSale);
        return sale;
    }

    public Sale update(Long id, NewSaleDTO updateSaleDto) {

        //Products
        List<ProductSale> productsForSale = new LinkedList<>();
        updateSaleDto.getProducts().forEach(prod -> productsForSale.add(converterToProductSale(prod)));

        String clientForSale = updateSaleDto.getNameClient();

        Sale newSale = converterToSale(productsForSale, clientForSale);
        newSale.setClient(clientForSale);
        newSale.setId(id);
        repository.save(newSale);
        productsForSale.forEach(productSale -> productSale.setSale(newSale));
        productsForSale.forEach(prod -> repositoryProductSale.save(prod));
        return newSale;
    }
}
