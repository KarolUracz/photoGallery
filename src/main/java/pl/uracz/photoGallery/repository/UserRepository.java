package pl.uracz.photoGallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.uracz.photoGallery.entity.Role;
import pl.uracz.photoGallery.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);
  @Query("SELECT u FROM User u inner join u.roles r WHERE r.name='ROLE_USER'")
  List<User> findAllByRoleUser();
  @Query(nativeQuery = true, value = "select * from user inner join photo_gallery where owner_id=user.id")
  List<User> findAllWithGallery();
}
