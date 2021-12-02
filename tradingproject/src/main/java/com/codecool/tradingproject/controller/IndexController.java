package com.codecool.tradingproject.controller;

import com.codecool.tradingproject.model.Product;
import com.codecool.tradingproject.model.Users;
import com.codecool.tradingproject.repository.ProductsRepository;
import com.codecool.tradingproject.service.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {
    @Autowired
    UserServiceImplementation usi;
    private Collection<Product> allProd = new ArrayList<>();
    private List<Product> lastFive = new ArrayList<>();
    private final ProductsRepository productsRepository;


    @PostConstruct
    private void loadData(){
        allProd = productsRepository.findAllByAuthorizedTrue();
        lastFive = productsRepository.findFirst5ByOrderByPublicationDateDesc();
    }


    @GetMapping("/")
    public String showStories(Model model) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        loadData();
        Users user = usi.findByUsername(authentication.getName());
        model.addAttribute("lastFive",lastFive);
        model.addAttribute("products",allProd);
        model.addAttribute("user",user);
        return "index";
    }
}
