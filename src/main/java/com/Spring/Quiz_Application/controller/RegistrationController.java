package com.Spring.Quiz_Application.controller;


import com.Spring.Quiz_Application.Dto.SignUpPageDto;
import com.Spring.Quiz_Application.entity.Candidate;
import com.Spring.Quiz_Application.entity.Host;
import com.Spring.Quiz_Application.repository.CandidateRepository;
import com.Spring.Quiz_Application.repository.HostRepository;
import com.Spring.Quiz_Application.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
    public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registration")
    public String processRegistrationForm(@ModelAttribute("user")@Valid SignUpPageDto signUpPageDto) {
        registrationService.register(signUpPageDto);
        return "redirect:/register?success";
    }
}


