package pl.uracz.photoGallery.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.uracz.photoGallery.entity.Image;
import pl.uracz.photoGallery.entity.PhotoGallery;
import pl.uracz.photoGallery.entity.User;
import pl.uracz.photoGallery.model.CurrentUser;
import pl.uracz.photoGallery.service.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private PhotoGalleryService photoGalleryService;
    private UserService userService;
    private FileStorageService fileStorageService;
    private ImageService imageService;


    public AdminController(PhotoGalleryService photoGalleryService, UserService userService, RoleService roleService, FileStorageService fileStorageService, ImageService imageService) {
        this.photoGalleryService = photoGalleryService;
        this.userService = userService;
        this.fileStorageService = fileStorageService;
        this.imageService = imageService;
    }

    @GetMapping("/panel")
    public String adminPanel(@AuthenticationPrincipal CurrentUser currentUser,
                             Model model) {
        model.addAttribute("admin", currentUser.getUsername());
        model.addAttribute("photoGallery", new PhotoGallery());
        model.addAttribute("user", new User());
        model.addAttribute("userList", userService.findAllWithoutGallery());
        return "/admin/panel";
    }

    @ModelAttribute
    public List<PhotoGallery> galleries() {
        return photoGalleryService.findAll();
    }

    @PostMapping("/addGallery")
    public String addGallery(@AuthenticationPrincipal CurrentUser currentUser,
                             @ModelAttribute PhotoGallery photoGallery) {
        photoGalleryService.save(photoGallery);
        fileStorageService.createGalleryDirectory(photoGallery.getOwner().getUsername());
        return "redirect:/admin/panel";
    }

    @GetMapping("/addPhotos/{galleryId}")
    public String addPhotos(@AuthenticationPrincipal CurrentUser currentUser,
                            @PathVariable String galleryId, Model model) {
        model.addAttribute("galleryToUpdate", photoGalleryService.findById(galleryId));
        return "/admin/addPhotos";
    }

    @PostMapping("/addPhotos")
    public String addPhotos(@AuthenticationPrincipal CurrentUser currentUser,
                            @ModelAttribute PhotoGallery photoGallery,
                            @RequestParam MultipartFile[] files) {
        for (MultipartFile file : files) {
            Image image = fileStorageService.storeFile(file, photoGallery);
            photoGallery.addImages(image);
        }
        return "redirect:/admin/panel";
    }

    @PostMapping("/addUser")
    public String addUser(@AuthenticationPrincipal CurrentUser currentUser,
                          @ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/admin/panel";
    }
}
