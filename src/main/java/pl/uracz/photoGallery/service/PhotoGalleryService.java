package pl.uracz.photoGallery.service;

import pl.uracz.photoGallery.entity.PhotoGallery;

import java.util.List;
import java.util.Optional;

public interface PhotoGalleryService {

    List<PhotoGallery> findAll ();

    void save(PhotoGallery photoGallery);

    PhotoGallery findById(String galleryId);
}
