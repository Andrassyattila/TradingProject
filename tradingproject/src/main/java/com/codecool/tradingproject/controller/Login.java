package com.codecool.tradingproject.controller;

import com.codecool.tradingproject.repository.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }


    @PostMapping
    public String Login(){


        return "redirect:/";
    }

}
