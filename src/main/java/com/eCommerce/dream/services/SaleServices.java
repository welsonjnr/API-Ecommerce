package com.eCommerce.dream.services;

import com.eCommerce.dream.domain.*;
import com.eCommerce.dream.dto.sale.NewSaleDTO;
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
import java.util.ArrayList;
import java.util.List;

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

    public Page<Sale> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Sale save(List<NewSaleDTO> objDto){

        List<ProductSale> productsForSale = new ArrayList<>();
        objDto.forEach(prod -> productsForSale.add(converterToProductSale(prod)));

        Client clientForSale = repositoryClient.findById(objDto.get(0).getIdClient()).get();

        if (!clientForSale.getName().equals(objDto.get(0).getNameClient())){
            throw new IllegalArgumentException("O Cliente não está de acordo com o banco de dados!. Tente arrumar os dados no banco" +
                    " de dados");
        }

        Sale sale = converterToSale(productsForSale, clientForSale);
        repository.save(sale);

        return sale;
    }

    public ProductSale converterToProductSale(NewSaleDTO productSaleForSale){

        //Product
        ProductSale productSale = new ProductSale();
        Product product = repositoryProduct.findById(productSaleForSale.getIdProduct()).get();

        if(product.getId().equals(productSaleForSale.getIdProduct()) && product.getName().equals(productSaleForSale.getNameProduct())){
            productSale.setProduct(product);
        }else{
            throw new IllegalArgumentException("O Produto não está de acordo com o banco de dados!. Tente arrumar no banco" +
                    "de dados");
        }

        productSale.setQuantity(productSaleForSale.getQuantity());
        productSale.setPreco(productSaleForSale.getPrice());
        productSale.setAmountSaleProduct(productSaleForSale.getPrice() * productSaleForSale.getQuantity());

        repositoryProductSale.save(productSale);

        return productSale;
    }

    private Sale converterToSale(List<ProductSale> productSale, Client client){

        Double amount = productSale.stream().mapToDouble(prod -> prod.getAmountSaleProduct().longValue()).sum();
        Sale sale = new Sale(null, amount, LocalDateTime.now(),SaleStatus.PENDING, client, productSale);

        productSale.forEach(prodsSale -> prodsSale.setSale(sale));

        return sale;
    }

}
