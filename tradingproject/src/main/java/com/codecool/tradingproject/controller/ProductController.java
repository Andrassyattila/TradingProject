package com.codecool.tradingproject.controller;

import com.codecool.tradingproject.model.Product;
import com.codecool.tradingproject.model.Users;
import com.codecool.tradingproject.repository.ProductsRepository;
import com.codecool.tradingproject.repository.UsersRepository;
import com.codecool.tradingproject.service.ProductServiceImplementation;
import com.codecool.tradingproject.service.UserService;
import com.codecool.tradingproject.service.UserServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class ProductController {

    ProductsRepository productsRepository;

    @GetMapping("/product/{id}")
    public String showProduct(@PathVariable(value="id")String id, Model model){
        Long idd=Long.parseLong(id);
        Product p = productsRepository.getById(idd);
        String url = "/Images/products/"+idd+"/"+p.getImage();
        model.addAttribute("product",p);
        model.addAttribute("url",url);
        return "product";
    }

}
