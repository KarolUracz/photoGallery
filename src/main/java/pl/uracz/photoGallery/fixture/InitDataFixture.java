package pl.uracz.photoGallery.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.uracz.photoGallery.entity.Role;
import pl.uracz.photoGallery.entity.User;
import pl.uracz.photoGallery.repository.RoleRepository;
import pl.uracz.photoGallery.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class InitDataFixture {

    private final RoleRepository roleRepository;
    private final UserService userService;

    @Autowired
    public InitDataFixture(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    public void initRoles() {
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleRepository.save(roleUser);
    }

    public void initUsers() {
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(roleRepository.findByName("ROLE_ADMIN"));
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setEnabled(1);
        admin.setRoles(adminRoles);
        userService.save(admin);

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleRepository.findByName("ROLE_USER"));

        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setEnabled(1);
        user.setRoles(userRoles);

        userService.save(user);
    }
}
