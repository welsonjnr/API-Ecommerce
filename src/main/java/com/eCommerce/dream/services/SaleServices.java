package com.eCommerce.dream.services;

import com.eCommerce.dream.domain.*;
import com.eCommerce.dream.dto.category.CategoryNewDTO;
import com.eCommerce.dream.dto.sale.SaleNewDTO;
import com.eCommerce.dream.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServices {

    @Autowired
    private SaleRepository repository;

    public Sale save(SaleNewDTO objDto){

        List<ProductSale> productSales = new ArrayList<>();
        objDto.getProducts().forEach(prod -> productSales.add(repository.findById(prod.getId()).get()));


/*
        List<Subcategories> subcategories = new ArrayList<>();
        objDto.getSubcategories().forEach(sub -> subcategories.add(repositorySubcategories.findById(sub).get()));

        Category category = new Category(null, objDto.getName(), products, subcategories);

        repositoryCategory.save(category);
*/
        return new Sale();
    }

}
