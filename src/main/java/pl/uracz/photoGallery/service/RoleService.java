package pl.uracz.photoGallery.service;

import pl.uracz.photoGallery.entity.Role;

public interface RoleService {
    Role findByName(String name);
}
