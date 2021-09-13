package com.eCommerce.dream.services;

import com.eCommerce.dream.domain.*;
import com.eCommerce.dream.dto.category.CategoryNewDTO;
import com.eCommerce.dream.repository.CategoryRepository;
import com.eCommerce.dream.repository.ProductRepository;
import com.eCommerce.dream.repository.SubcategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository repositoryCategory;

    @Autowired
    private ProductRepository repositoryProduct;

    @Autowired
    private SubcategoriesRepository repositorySubcategories;

    public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repositoryCategory.findAll(pageRequest);
    }

    public Category save(CategoryNewDTO objDto){

        Category category = new Category();

        if (objDto.getSubcategories().isEmpty()){
            category = new Category(null, objDto.getName());
        }
        else {
            List<Subcategories> subcategories = new ArrayList<>();
            objDto.getSubcategories().forEach(sub -> subcategories.add(repositorySubcategories.findById(sub).get()));
            category.setSubcategories(subcategories);
        }

        repositoryCategory.save(category);

        return category;
    }
}
