package pl.uracz.photoGallery.service;

import org.springframework.web.multipart.MultipartFile;
import pl.uracz.photoGallery.entity.Image;

public interface FileStorageService {

    public Image storeFile(MultipartFile file, String username);

    public void createGalleryDirectory(String username);
}
