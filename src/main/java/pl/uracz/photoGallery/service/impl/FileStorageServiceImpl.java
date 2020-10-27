package pl.uracz.photoGallery.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.uracz.photoGallery.entity.Image;
import pl.uracz.photoGallery.entity.PhotoGallery;
import pl.uracz.photoGallery.exception.FileStorageException;
import pl.uracz.photoGallery.service.FileStorageService;
import pl.uracz.photoGallery.service.ImageService;
import pl.uracz.photoGallery.service.PhotoGalleryService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class FileStorageServiceImpl implements FileStorageService {

    private String uploadDir = "src/main/resources/static";

    private ImageService imageService;
    private PhotoGalleryService photoGalleryService;

    public FileStorageServiceImpl(ImageService imageService, PhotoGalleryService photoGalleryService) {
        this.imageService = imageService;
        this.photoGalleryService = photoGalleryService;
    }

    public void createGalleryDirectory(String username) {
        try {
            Path path = Paths.get(uploadDir + File.separator + username);
            if (!Files.exists(path)) {
                Files.createDirectory(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Image storeFile(MultipartFile file, PhotoGallery photoGallery) {
        Image image = new Image();
        try {
            Path copyLocation = Paths
                    .get(uploadDir + File.separator + photoGallery.getOwner().getUsername() + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Path imagePath = Paths.get(File.separator + photoGallery.getOwner().getUsername() + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            image.setUrl(imagePath.toString());
            image.setPhotoGallery(photoGallery);
            imageService.saveImage(imagePath.toString(), photoGallery);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename());
        }
        return image;
    }
}
