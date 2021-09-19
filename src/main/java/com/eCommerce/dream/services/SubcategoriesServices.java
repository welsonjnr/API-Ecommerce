package com.eCommerce.dream.services;

import com.eCommerce.dream.domain.Category;
import com.eCommerce.dream.domain.Product;
import com.eCommerce.dream.domain.Subcategories;
import com.eCommerce.dream.dto.category.CategoryNewDTO;
import com.eCommerce.dream.dto.subcategories.SubcategoriesDTO;
import com.eCommerce.dream.repository.CategoryRepository;
import com.eCommerce.dream.repository.SubcategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubcategoriesServices {


    @Autowired
    private SubcategoriesRepository repository;

    @Autowired
    private CategoryRepository repositoryCat;

    public Subcategories save(SubcategoriesDTO objDto){

        Category category = repositoryCat.findById(objDto.getId()).get();
        Subcategories subcategories = new Subcategories(null, objDto.getName(), category);
        repository.save(subcategories);

        return subcategories;
    }
}
