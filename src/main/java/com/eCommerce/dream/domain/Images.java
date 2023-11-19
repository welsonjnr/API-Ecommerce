
package com.eCommerce.dream.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
public class Images {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageName;
    private String type;

    @Lob
    @Column(length = 1000)
    private byte[] images;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="product_imgs_id")
    private Product product;

    public Images() {}

    public Images(byte[] images) {
        this.images = images;
    }

    public Images(String imageName, String type, byte[] images) {
        this.imageName = imageName;
        this.type = type;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Images other = (Images) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
       
}
