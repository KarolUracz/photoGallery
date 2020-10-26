package pl.uracz.photoGallery.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.uracz.photoGallery.exception.FileStorageException;
import pl.uracz.photoGallery.service.FileStorageService;
import pl.uracz.photoGallery.service.ImageService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class FileStorageServiceImpl implements FileStorageService {

    private String uploadDir = "D:/java20/photoGallery/src/main/resources/static";

    private ImageService imageService;

    public FileStorageServiceImpl(ImageService imageService) {
        this.imageService = imageService;
    }

    public void createGalleryDirectory(String username) {
        try {
            Path path = Paths.get(uploadDir + File.separator + username);
            Files.createDirectory(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeFile(MultipartFile file, String username) {
        try {
            Path copyLocation = Paths
                    .get(uploadDir + File.separator + username + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            imageService.saveImage(copyLocation.toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename());
        }
    }
}
