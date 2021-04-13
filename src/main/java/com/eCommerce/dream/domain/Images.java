
package com.eCommerce.dream.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Images {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    @ManyToOne
    @JoinColumn(name="product_imgs_id")
    private Product product;

    public Images() {}

    public Images(Long id, Product product) {
        this.id = id;
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
