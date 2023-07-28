package com.Spring.Quiz_Application.controller;




import com.Spring.Quiz_Application.Dto.SignUpPageDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    @GetMapping("/login")
    public ModelAndView showLoginForm(Model model) {
        model.addAttribute("user", new SignUpPageDto()); // Create a SignUpPageDto class to hold the form data
        return new ModelAndView("LoginForm");
    }
    @GetMapping("/register")
    public  ModelAndView showRegistrationForm(Model model) {
        model.addAttribute("user", new SignUpPageDto()); // Create a SignUpPageDto class to hold the form data
        return new ModelAndView("SignupForm");
    }
    @GetMapping("/home")
    public ModelAndView homeHandler(){
        return new ModelAndView("home");
    }

}
