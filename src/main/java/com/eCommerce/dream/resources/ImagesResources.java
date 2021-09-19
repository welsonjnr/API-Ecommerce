package com.eCommerce.dream.resources;


import com.eCommerce.dream.domain.Category;
import com.eCommerce.dream.domain.Images;
import com.eCommerce.dream.domain.Product;
import com.eCommerce.dream.dto.category.CategoryNewDTO;
import com.eCommerce.dream.repository.ImagesRepository;
import com.eCommerce.dream.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/ecommerce/images")
public class ImagesResources {

    @Autowired
    private ImagesRepository imagesRepository;

    @Autowired
    private ProductRepository repositoryProduct;

    @PostMapping("/upload/{id}")
    public ResponseEntity<?> uploadImage(@RequestParam("imageFile")MultipartFile file, @PathVariable Long id) throws IOException {
        Images img = new Images(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        Product product = repositoryProduct.findById(id).get();
        product.getImgs().add(img);
        img.setProduct(product);
        imagesRepository.save(img);
        return ResponseEntity.ok().body(img.getImageName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id){
        final Optional<Images> retrivedImage = imagesRepository.findById(id);
        Images img = new Images(retrivedImage.get().getImageName(), retrivedImage.get().getType(), retrivedImage.get().getImages());
        byte[] image = img.getImages();
        return (!retrivedImage.isEmpty()) ?
                ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return imagesRepository.findById(id)
                .map(img -> {
                    imagesRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
