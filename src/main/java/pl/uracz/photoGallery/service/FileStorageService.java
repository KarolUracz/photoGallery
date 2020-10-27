package pl.uracz.photoGallery.service;

import org.springframework.web.multipart.MultipartFile;
import pl.uracz.photoGallery.entity.Image;
import pl.uracz.photoGallery.entity.PhotoGallery;

public interface FileStorageService {

    public Image storeFile(MultipartFile file, PhotoGallery photoGallery);

    public void createGalleryDirectory(String username);
}
