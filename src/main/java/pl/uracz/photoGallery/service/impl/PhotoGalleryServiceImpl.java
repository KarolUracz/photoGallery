package pl.uracz.photoGallery.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.photoGallery.entity.PhotoGallery;
import pl.uracz.photoGallery.entity.User;
import pl.uracz.photoGallery.repository.PhotoGalleryRepository;
import pl.uracz.photoGallery.repository.UserRepository;
import pl.uracz.photoGallery.service.PhotoGalleryService;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoGalleryServiceImpl implements PhotoGalleryService {

    private PhotoGalleryRepository photoGalleryRepository;
    private UserRepository userRepository;

    public PhotoGalleryServiceImpl(PhotoGalleryRepository photoGalleryRepository, UserRepository userRepository) {
        this.photoGalleryRepository = photoGalleryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<PhotoGallery> findAll() {
        return photoGalleryRepository.findAll();
    }

    @Override
    public void save(PhotoGallery photoGallery) {
        User galleryUser = userRepository.findByUsername(photoGallery.getOwner().getUsername());
        photoGallery.setOwner(galleryUser);
        photoGalleryRepository.save(photoGallery);
    }

    @Override
    public PhotoGallery findById(String galleryId) {
        long galleryIdToSearch = Long.parseLong(galleryId);
        return photoGalleryRepository.findById(galleryIdToSearch).orElse(null);
    }
}
