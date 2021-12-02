package com.codecool.tradingproject.controller;


import com.codecool.tradingproject.model.Product;
import com.codecool.tradingproject.repository.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Controller
public class ModeratorController {
    private final ProductsRepository productsRepository;


    @GetMapping("/moderator")
    public String getModeratorSite(Model model){
        List<Product> allProduct = new ArrayList<>();
        allProduct = productsRepository.findAll();
        Collection<Product> needToBeAuthorized = new ArrayList<>();
        needToBeAuthorized=productsRepository.findAllByAuthorized();
        System.out.println(needToBeAuthorized);
        model.addAttribute("newProducts",needToBeAuthorized);
        return "moderator";

    }



    @RequestMapping(path = "/moderator/product/{id}",method = RequestMethod.GET)
    public String showProduct(@PathVariable(value="id")String id, Model model){
        Long idd=Long.parseLong(id);
        Product p = productsRepository.getById(idd);
        String url = "/Images/products/"+idd+"/"+p.getImage();
        model.addAttribute("product",p);
        model.addAttribute("url",url);
        return "/unauthorizedproduct";
    }

    @PostMapping("/moderator/product/{id}/pass")
    public String passProduct(@PathVariable(value = "id")String id){
        Long productId=Long.parseLong(id);
        Product product= productsRepository.getById(productId);
        product.setAuthorized(true);
        productsRepository.save(product);
        return "redirect:/moderator";
    }

    @PostMapping("/moderator/product/{id}/delete")
    public String deleteProduct(@PathVariable(value = "id")String id){
        Long productId=Long.parseLong(id);
        Product product= productsRepository.getById(productId);
        productsRepository.delete(product);
        return "redirect:/moderator";
    }



}
