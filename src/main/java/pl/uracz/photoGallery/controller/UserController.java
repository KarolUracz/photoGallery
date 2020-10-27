package pl.uracz.photoGallery.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.uracz.photoGallery.entity.Image;
import pl.uracz.photoGallery.entity.PhotoGallery;
import pl.uracz.photoGallery.model.CurrentUser;
import pl.uracz.photoGallery.service.PhotoGalleryService;

import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    private PhotoGalleryService photoGalleryService;

    public UserController(PhotoGalleryService photoGalleryService) {
        this.photoGalleryService = photoGalleryService;
    }

    @GetMapping("/panel")
    public String userPanel (@AuthenticationPrincipal CurrentUser currentUser,
                             Model model) {
        PhotoGallery byOwner = photoGalleryService.findByOwner_Username(currentUser.getUser().getUsername());
        Set<Image> images = byOwner.getImages();
        model.addAttribute("images", byOwner);
        return "/user/userPanel";
    }
}
