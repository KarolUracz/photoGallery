package pl.uracz.photoGallery.service;

import pl.uracz.photoGallery.entity.PhotoGallery;

public interface ImageService {
    void saveImage(String imageUrl, PhotoGallery photoGallery);
}
