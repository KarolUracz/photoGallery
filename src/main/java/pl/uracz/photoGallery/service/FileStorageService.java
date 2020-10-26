package pl.uracz.photoGallery.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    public void storeFile(MultipartFile file, String username);
}
