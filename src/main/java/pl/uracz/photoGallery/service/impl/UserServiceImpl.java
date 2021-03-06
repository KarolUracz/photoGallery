package pl.uracz.photoGallery.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.uracz.photoGallery.entity.Role;
import pl.uracz.photoGallery.entity.User;
import pl.uracz.photoGallery.repository.RoleRepository;
import pl.uracz.photoGallery.repository.UserRepository;
import pl.uracz.photoGallery.service.PhotoGalleryService;
import pl.uracz.photoGallery.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final BCryptPasswordEncoder passwordEncoder;
  private final PhotoGalleryService photoGalleryService;

  public UserServiceImpl(UserRepository userRepository,
                         RoleRepository roleRepository,
                         BCryptPasswordEncoder passwordEncoder, PhotoGalleryService photoGalleryService) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
    this.photoGalleryService = photoGalleryService;
  }

  @Override
  public User findByUserName(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public void save(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setEnabled(1);
    userRepository.save(user);
  }

  @Override
  public void saveUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setEnabled(1);
    Role userRole = roleRepository.findByName("ROLE_USER");
    user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    userRepository.save(user);
  }

  @Override
  public List<User> findAllByRoleUser() {
    return userRepository.findAllByRoleUser();
  }

  @Override
  public List<User> findAllWithoutGallery() {
    List<User> allWithGallery = userRepository.findAllWithGallery();
    List<User> allByRoleUser = userRepository.findAllByRoleUser();
    allByRoleUser.removeAll(allWithGallery);
    return allByRoleUser;
  }
}
