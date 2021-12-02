package com.codecool.tradingproject.controller;


import com.codecool.tradingproject.model.Users;
import com.codecool.tradingproject.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class Registration {
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user",new Users());
        return"reg2";
    }

    @PostMapping("/registration")
    public String regRedirect(@ModelAttribute Users users){
        if(usersRepository.findByUsername(users.getUsername()) != null){
            throw new IllegalStateException("Username is already used!");
        }
        String encodedPw = bCryptPasswordEncoder.encode(users.getPassword());
        users.setPassword(encodedPw);
        usersRepository.save(users);
        return"redirect:/";
    }
}
