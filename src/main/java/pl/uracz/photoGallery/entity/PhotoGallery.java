package pl.uracz.photoGallery.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PhotoGallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String galleryName;
    @OneToOne
    private User owner;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "photoGallery")
    private Set<Image> images = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGalleryName() {
        return galleryName;
    }

    @PrePersist
    public void setGalleryName() {
        this.galleryName = owner.getUsername();
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public void addImages(Image image) {
        images.add(image);
    }
}
