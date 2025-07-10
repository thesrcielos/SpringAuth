package com.example.demo;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String processSignup(@ModelAttribute User user, HttpSession httpSession) {
        System.out.println("user = " + user);
        userService.registerUser(user, httpSession);
        return "redirect:/hello";
    }
}
