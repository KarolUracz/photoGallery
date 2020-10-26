package pl.uracz.photoGallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.photoGallery.entity.Image;
import pl.uracz.photoGallery.entity.PhotoGallery;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAll();
}
