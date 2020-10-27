package pl.uracz.photoGallery.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.photoGallery.entity.Image;
import pl.uracz.photoGallery.entity.PhotoGallery;
import pl.uracz.photoGallery.repository.ImageRepository;
import pl.uracz.photoGallery.service.ImageService;
import pl.uracz.photoGallery.service.PhotoGalleryService;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;
    private PhotoGalleryService photoGalleryService;

    public ImageServiceImpl(ImageRepository imageRepository, PhotoGalleryService photoGalleryService) {
        this.imageRepository = imageRepository;
        this.photoGalleryService = photoGalleryService;
    }

    @Override
    public void saveImage(String imageUrl, PhotoGallery photoGallery) {
        Image image = new Image();
        image.setUrl(imageUrl);
        image.setPhotoGallery(photoGallery);
        imageRepository.save(image);
    }
}
