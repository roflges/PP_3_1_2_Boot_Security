package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showGreetingPage() {
        return "greeting";
    }

    @GetMapping("/user")
    public String showUserPage(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByName(principal.getName()));
        return "user";
    }
}