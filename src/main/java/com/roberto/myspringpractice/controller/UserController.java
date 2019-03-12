package com.roberto.myspringpractice.controller;

import com.roberto.myspringpractice.model.User;
import com.roberto.myspringpractice.repositories.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class UserController {
    private Users users;
    private PasswordEncoder passwordEncoder;


    public UserController(Users users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/login")
    public String login(){
        return "users/login";
    }

    @GetMapping("/logout")
    public String logout(){

        return "redirect:/login";
    }


    @GetMapping("/home")
    public String home( Model model){
        model.addAttribute("user", new User());
        return "users/home";
    }


    @GetMapping("/sign-up")
    public  String showSignupForm( Model model){
        model.addAttribute("user",new User());
        return "users/register";
    }




    @PostMapping("/sign-up")
    public String crearUsario(@ModelAttribute User user){
        String hash=passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";

    }
}
