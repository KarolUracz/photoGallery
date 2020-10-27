package pl.uracz.photoGallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.uracz.photoGallery.entity.PhotoGallery;
import pl.uracz.photoGallery.entity.User;

import java.util.List;

@Repository
public interface PhotoGalleryRepository extends JpaRepository<PhotoGallery, Long> {
    List<PhotoGallery> findAll ();
    PhotoGallery findByOwner_Username(String username);
}
