package pl.uracz.photoGallery.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.photoGallery.entity.Image;
import pl.uracz.photoGallery.repository.ImageRepository;
import pl.uracz.photoGallery.service.ImageService;
import pl.uracz.photoGallery.service.PhotoGalleryService;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository, PhotoGalleryService photoGalleryService) {
        this.imageRepository = imageRepository;
    }

    @Override
    public void saveImage(String imageUrl) {
        Image image = new Image();
        image.setUrl(imageUrl);
        imageRepository.save(image);
    }
}
