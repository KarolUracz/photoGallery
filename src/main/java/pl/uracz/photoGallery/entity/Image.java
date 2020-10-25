package pl.uracz.photoGallery.entity;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private PhotoGallery photoGallery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhotoGallery getPhotoGallery() {
        return photoGallery;
    }

    public void setPhotoGallery(PhotoGallery photoGallery) {
        this.photoGallery = photoGallery;
    }
}
