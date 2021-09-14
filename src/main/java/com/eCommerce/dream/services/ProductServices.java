package com.eCommerce.dream.services;

import com.eCommerce.dream.domain.*;
import com.eCommerce.dream.dto.address.AddressDetailDTO;
import com.eCommerce.dream.dto.client.ClientNewDTO;
import com.eCommerce.dream.dto.product.ProductNewDTO;
import com.eCommerce.dream.repository.CategoryRepository;
import com.eCommerce.dream.repository.ImagesRepository;
import com.eCommerce.dream.repository.PriceRepository;
import com.eCommerce.dream.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Page<Product> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Product save(ProductNewDTO objDto){
        Price price = new Price(objDto.getCostPrice(), objDto.getSalePrice());
        repositoryPrice.save(price);

        List<Category> categories = new ArrayList<>();
        Category category = repositoryCategory.findByName(objDto.getNameCategory());
        categories.add(category);

        Product product = new Product(null, objDto.getName(), objDto.getDescription(), objDto.getShorDescription(), objDto.getSpecifications(), objDto.getQuantity(), objDto.getAvailable(), objDto.getSize(), objDto.getBrand(), objDto.getUnity(), price, categories);

        repository.save(product);

        return product;
    }
}
