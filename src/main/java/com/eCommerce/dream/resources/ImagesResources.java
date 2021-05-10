package com.eCommerce.dream.resources;


import com.eCommerce.dream.domain.Images;
import com.eCommerce.dream.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImagesResources {

    @Autowired
    private ImagesRepository imagesRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("imageFile")MultipartFile file) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        Images img = new Images(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        imagesRepository.save(img);
        return ResponseEntity.ok().body(img.getImageName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id){
        final Optional<Images> retrivedImage = imagesRepository.findById(id);
        Images img = new Images(retrivedImage.get().getImageName(), retrivedImage.get().getType(), retrivedImage.get().getImages());
        byte[] image = img.getImages();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
}
