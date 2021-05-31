package com.eCommerce.dream.services;

import com.eCommerce.dream.domain.*;
import com.eCommerce.dream.dto.address.AddressDTO;
import com.eCommerce.dream.dto.sale.ProductSaleNewDTO;
import com.eCommerce.dream.enums.SaleStatus;
import com.eCommerce.dream.repository.ClientRepository;
import com.eCommerce.dream.repository.ProductRepository;
import com.eCommerce.dream.repository.ProductSaleRepository;
import com.eCommerce.dream.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServices {

    @Autowired
    private ProductSaleRepository repositoryProductSale;

    @Autowired
    private ClientRepository repositoryClient;

    @Autowired
    private ProductRepository repositoryProduct;

    @Autowired
    private SaleRepository repository;

    public Sale save(List<ProductSaleNewDTO> objDto, Long client){

        List<ProductSale> productSales = new ArrayList<>();
        objDto.forEach(prod -> productSales.add(converterToProductSale(prod)));

        Client cliSale = repositoryClient.findById(client).get();

        Sale sale = converterToSale(productSales, cliSale);

        repository.save(sale);

        return sale;
    }

    public ProductSale converterToProductSale(ProductSaleNewDTO productForSale){
        ProductSale productSale = new ProductSale();
        productSale.setProduct(repositoryProduct.findById(productForSale.getProduct()).get());
        productSale.setPreco(productForSale.getPrice());
        productSale.setQuantity(productForSale.getQuantity());
        productSale.setAmountSaleProduct(productForSale.getPrice().multiply(BigDecimal.valueOf(productForSale.getQuantity())));

        repositoryProductSale.save(productSale);

        return productSale;
    }

    private Sale converterToSale(List<ProductSale> productSale, Client client){
        Double amount = productSale.stream().map(prod -> prod.getAmountSaleProduct()).reduce((prod, y) -> BigDecimal.valueOf(prod) + BigDecimal.valueOf(y)).orElse(0.0);

        Sale newSale = new Sale(null, BigDecimal.valueOf(amount), LocalDateTime.now()
                , SaleStatus.PENDING, client, productSale);

        return newSale;
    }

}
