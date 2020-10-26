package pl.uracz.photoGallery.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.uracz.photoGallery.exception.FileStorageException;
import pl.uracz.photoGallery.service.FileStorageService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${images.path}")
    private String uploadDir;

    @Override
    public void storeFile(MultipartFile file, String username) {
        try {
            Path copyLocation = Paths
                    .get(uploadDir + "/" + username + "/" + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename());
        }
    }
}
