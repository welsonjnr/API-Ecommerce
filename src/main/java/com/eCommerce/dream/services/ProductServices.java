package com.eCommerce.dream.services;

import com.eCommerce.dream.domain.*;
import com.eCommerce.dream.dto.address.AddressDetailDTO;
import com.eCommerce.dream.dto.client.ClientNewDTO;
import com.eCommerce.dream.dto.image.ImagesDTO;
import com.eCommerce.dream.dto.product.ProductNewDTO;
import com.eCommerce.dream.dto.product.ProductUpdateDTO;
import com.eCommerce.dream.repository.CategoryRepository;
import com.eCommerce.dream.repository.ImagesRepository;
import com.eCommerce.dream.repository.PriceRepository;
import com.eCommerce.dream.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private PriceRepository repositoryPrice;

    @Autowired
    private CategoryRepository repositoryCategory;

    public Page<Product> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Product save(ProductNewDTO objDto){
        Price price = new Price(objDto.getCostPrice(), objDto.getSalePrice());
        repositoryPrice.save(price);

        Category category = repositoryCategory.findByName(objDto.getNameCategory());

        Product product = new Product(null, objDto.getName(), objDto.getDescription(), objDto.getShorDescription(),
                objDto.getSpecifications(), objDto.getQuantity(), objDto.getAvailable(), objDto.getSize(),
                objDto.getBrand(), objDto.getUnity(), price, category);

        repository.save(product);
        return product;
    }

    public Product update(ProductUpdateDTO objDto, Long id) {
        repository.findById(id)
                .map(product -> {
                    product.setName(objDto.getName());
                    product.setDescription(objDto.getDescription());
                    product.setShortDescription(objDto.getShorDescription());
                    product.setSpecifications(objDto.getSpecifications());
                    product.setQuantity(objDto.getQuantity());
                    product.setSize(objDto.getSize());
                    product.setBrand(objDto.getBrand());
                    product.setUnity(objDto.getUnity());
                    updatePrice(product, objDto.getSalePrice(), objDto.getCostPrice());
                    Product updated = repository.save(product);
                    return updated;
                });
        return repository.findById(id).get();
    }

    private Price updatePrice(Product product, Double newSalePrice, Double newCostPrice){
        repositoryPrice.findById(product.getPrice().getId())
                .map(price -> {
                    price.setSalePrice(newSalePrice);
                    price.setCostPrice(newCostPrice);
                    Price updated = repositoryPrice.save(price);
                    return updated;
                });

        return null;
    }
}
