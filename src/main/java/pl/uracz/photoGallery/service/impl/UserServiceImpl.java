package pl.uracz.photoGallery.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.uracz.photoGallery.entity.Role;
import pl.uracz.photoGallery.entity.User;
import pl.uracz.photoGallery.repository.RoleRepository;
import pl.uracz.photoGallery.repository.UserRepository;
import pl.uracz.photoGallery.service.UserService;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository userRepository,
      RoleRepository roleRepository,
      BCryptPasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User findByUserName(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public void saveUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setEnabled(1);
    Role userRole = roleRepository.findByName("ROLE_USER");
    user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    userRepository.save(user);
  }
}
