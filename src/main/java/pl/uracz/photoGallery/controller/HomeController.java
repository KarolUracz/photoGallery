package pl.uracz.photoGallery.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.uracz.photoGallery.fixture.InitDataFixture;
import pl.uracz.photoGallery.model.CurrentUser;

@Controller
public class HomeController {

    private InitDataFixture initDataFixture;

    public HomeController(InitDataFixture initDataFixture) {
        this.initDataFixture = initDataFixture;
    }

    @RequestMapping("/initData")
    @ResponseBody
    public String initData() {
        initDataFixture.initRoles();
        initDataFixture.initUsers();
        return "initialized";
    }

    @GetMapping("/")
    public String loginAction(@AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/admin/panel";
        } else if (currentUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            return "redirect:/user/panel";
        }
        return null;
    }
}
