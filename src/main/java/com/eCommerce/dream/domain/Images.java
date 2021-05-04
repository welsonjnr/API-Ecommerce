
package com.eCommerce.dream.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Images {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Lob
    private List<byte[]> images;

    @ManyToOne
    @JoinColumn(name="product_imgs_id")
    private Product product;

    public Images() {}

    public Images(Long id, List<byte[]> images, Product product) {
        this.id = id;
        this.images = images;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<byte[]> getImages() {
        return images;
    }

    public void setImages(List<byte[]> images) {
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
