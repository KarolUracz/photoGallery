package pl.uracz.photoGallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.uracz.photoGallery.fixture.InitDataFixture;

@Controller
public class HomeController {

    private InitDataFixture initDataFixture;

    public HomeController(InitDataFixture initDataFixture) {
        this.initDataFixture = initDataFixture;
    }

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping("/initData")
    @ResponseBody
    public String initData() {
        initDataFixture.initRoles();
        initDataFixture.initUsers();
        return "initialized";
    }



}
