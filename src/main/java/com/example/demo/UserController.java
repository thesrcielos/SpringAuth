package com.example.demo;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * This is a controller that exposes the service to register a user
 */
@Controller
public class UserController {
    private final  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * This method register a user
     * @param user user to register
     * @param httpSession the actual session
     * @return page hello
     */
    @PostMapping("/signup")
    public String processSignup(@ModelAttribute User user, HttpSession httpSession) {
        System.out.println("user = " + user);
        userService.registerUser(user, httpSession);
        return "redirect:/hello";
    }
}
