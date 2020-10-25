package pl.uracz.photoGallery.service;

import pl.uracz.photoGallery.entity.User;

public interface UserService {

  User findByUserName(String username);

  void saveUser(User user);

}
