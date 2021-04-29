package com.eCommerce.dream.services;

import com.eCommerce.dream.domain.*;
import com.eCommerce.dream.dto.client.ClientNewDTO;
import com.eCommerce.dream.dto.product.ProductNewDTO;
import com.eCommerce.dream.repository.CategoryRepository;
import com.eCommerce.dream.repository.ImagesRepository;
import com.eCommerce.dream.repository.PriceRepository;
import com.eCommerce.dream.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ImagesRepository repositoryImages;

    @Autowired
    private PriceRepository repositoryPrice;

    @Autowired
    private CategoryRepository repositoryCategory;

    public Product save(ProductNewDTO objDto){
        List<Price> prices = objDto.getPrices();
        repositoryPrice.saveAll(prices);

        List<Images> imgs = objDto.getImgs();
        repositoryImages.saveAll(imgs);

        Category category = repositoryCategory.findById(objDto.getCategory().getId()).get();

        Product product = new Product(null, objDto.getName(), objDto.getDescription(), objDto.getShorDescription(), objDto.getSpecifications(), objDto.getQuantity(), objDto.getAvailable(),
                objDto.getSize(), objDto.getBrand(), objDto.getUnity(), prices, imgs, category);

        repository.save(product);

        return product;
    }
}
