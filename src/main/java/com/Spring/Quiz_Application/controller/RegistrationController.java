package com.Spring.Quiz_Application.controller;
import com.Spring.Quiz_Application.Dto.SignUpPageDto;
import com.Spring.Quiz_Application.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
    public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registration")
    public String processRegistrationForm(@ModelAttribute("user") @Valid SignUpPageDto signUpPageDto, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("ERROR: "+result.toString());
         return "SignupForm";
        }
        registrationService.register(signUpPageDto);
        return "redirect:/register?success";
    }
}


