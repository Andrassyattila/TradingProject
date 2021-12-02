package com.codecool.tradingproject.controller;

import com.codecool.tradingproject.model.Users;
import com.codecool.tradingproject.repository.ProductsRepository;
import com.codecool.tradingproject.repository.UsersRepository;
import com.codecool.tradingproject.service.UserService;
import com.codecool.tradingproject.service.UserServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
public class Profile {
    UserService userService;
    UserServiceImplementation usi;
    ProductsRepository productsRepository;
    UsersRepository usersRepository;

    @GetMapping("/myprofile")
    public String showMyProfile(Model model){
        Boolean isMyProfile =true;
        var context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Users profile = usi.findByUsername(authentication.getName());

        model.addAttribute("user",profile);
        model.addAttribute("isMyProfile",isMyProfile);
        return "profile";
    }

    @GetMapping("/profile/{id}")
    public String showProfile(@PathVariable(value="id")String id,Model model){
        Long idd = Long.parseLong(id);
        Boolean isMyProfile;
        var context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Users profile = usi.findByUsername(authentication.getName());
        Users user = usersRepository.getById(idd);
        if(idd.equals(profile.getId())){
            isMyProfile=true;
        }else{
            isMyProfile=false;
        }

        model.addAttribute("user",user);
        model.addAttribute("isMyProfile",isMyProfile);
        return "profile";
    }

    @GetMapping("/profile/edit")
    public String showProfileEdit(Model model){
        var context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Users profile = userService.findByUsername(authentication.getName());
        System.out.println(profile);
        model.addAttribute("profile",profile);
        return "edit";
    }

    @PostMapping("/profile/edit")
    public String updateProfile(@ModelAttribute Users profile){
        var context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Users u = userService.findByUsername(authentication.getName());


        usi.updateUser(u.getId(),profile);
        return "redirect:/profile";
    }

    @GetMapping("/profile/myproducts")
    public String showProfileProducts(Model model){
        var context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Users profile = usi.findByUsername(authentication.getName());
        model.addAttribute("user",profile);
        return "profileproducts";
    }

    @PostMapping("/profile/rating/{id}")
    public String ratingProfile(@PathVariable(value="id")String id,@RequestParam("rating")String rating){
        Long idd= Long.parseLong(id);
        int newRating= Integer.parseInt(rating);
        System.out.println(newRating);
        Users u = usersRepository.getById(idd);
        u.setRating((u.getRatingcounter()*u.getRating()+newRating)/(u.getRatingcounter()+1));
        u.setRatingcounter(u.getRatingcounter()+1);
        usi.updateUser(u.getId(),u);
        return "redirect:/profile/"+id;
    }
}
