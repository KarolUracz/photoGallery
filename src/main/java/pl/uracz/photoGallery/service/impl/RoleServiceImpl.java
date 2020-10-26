package pl.uracz.photoGallery.service.impl;

import org.springframework.stereotype.Service;
import pl.uracz.photoGallery.entity.Role;
import pl.uracz.photoGallery.repository.RoleRepository;
import pl.uracz.photoGallery.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
