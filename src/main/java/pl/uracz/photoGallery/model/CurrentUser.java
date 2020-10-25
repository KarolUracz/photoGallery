package pl.uracz.photoGallery.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {

    private  final pl.uracz.photoGallery.entity.User user;

    public CurrentUser(
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            pl.uracz.photoGallery.entity.User user) {
        super(username, password, authorities);
        this.user = user;
    }
    public pl.uracz.photoGallery.entity.User getUser() {return user;}
}
