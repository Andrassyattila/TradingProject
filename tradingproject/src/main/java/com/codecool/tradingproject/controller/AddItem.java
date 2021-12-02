package com.codecool.tradingproject.controller;

import com.codecool.tradingproject.model.Categories;
import com.codecool.tradingproject.model.Product;
import com.codecool.tradingproject.repository.CategoryRepository;
import com.codecool.tradingproject.repository.ProductsRepository;
import com.codecool.tradingproject.service.AddPhotoService;
import com.codecool.tradingproject.service.UserServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@AllArgsConstructor
@Controller
public class AddItem {

    private final AddPhotoService addPhotoService;
    private final ProductsRepository productsRepository;
    private final UserServiceImplementation userServiceImplementation;
    private final CategoryRepository categoryRepository;

    @Secured("ROLE_USER")
    @GetMapping("/add")
    public String ItemPage(Model model) {
        List<Categories> categories = categoryRepository.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("product",new Product());
        return "additem";
    }


    @PostMapping("/add")
    public String addItem(@RequestParam("imageFile") MultipartFile imageFile, @ModelAttribute Product product){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        //adatbázis image path nélkül
        product.setImage(imageFile.getOriginalFilename());
        product.setUsers(userServiceImplementation.findByUsername(authentication.getName()));
        productsRepository.save(product);
        System.out.println(product.getId());

        //kép mentése
        try {
            addPhotoService.saveImage(imageFile,product.getId());
        } catch (Exception e) {
            e.printStackTrace();

        }
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String deleteItem(){
        //delete route
        return "redirect:/";
    }
}
