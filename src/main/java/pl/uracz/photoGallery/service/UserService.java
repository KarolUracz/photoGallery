package pl.uracz.photoGallery.service;

import pl.uracz.photoGallery.entity.User;

import java.util.List;

public interface UserService {

    User findByUserName(String username);

    void save(User user);

    void saveUser(User user);

    List<User> findAllByRoleUser();

}
