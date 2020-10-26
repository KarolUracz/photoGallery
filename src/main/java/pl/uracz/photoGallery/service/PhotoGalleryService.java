package pl.uracz.photoGallery.service;

import pl.uracz.photoGallery.entity.PhotoGallery;

import java.util.List;

public interface PhotoGalleryService {

    List<PhotoGallery> findAll ();

    void save(PhotoGallery photoGallery);

    PhotoGallery findById(String galleryId);
}
