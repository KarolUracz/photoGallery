package pl.uracz.photoGallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uracz.photoGallery.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);
}
