package com.eCommerce.dream.dto.image;

import javax.persistence.Column;

public class ImagesDTO {

    @Column(length = 1000)
    private byte[] images;

    public ImagesDTO() {
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }
}
