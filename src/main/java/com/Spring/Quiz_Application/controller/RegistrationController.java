
package com.Spring.Quiz_Application.controller;


import com.Spring.Quiz_Application.Dto.SignUpPageDto;

import com.Spring.Quiz_Application.service.RegistrationService;
import com.Spring.Quiz_Application.utils.CustomMailSender;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
    public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;





        @Autowired
        private CustomMailSender mailSender;

    @PostMapping("/registration")
    public String processRegistrationForm(@ModelAttribute("user") @Valid SignUpPageDto signUpPageDto, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("ERROR: " + result.toString());
            return "SignupForm";
        }


        registrationService.register(signUpPageDto);



        return "redirect:/registration";

    }

    @GetMapping("/verificationSuccess")
    public String verificationSuccess() {
        return "verificationSuccess"; // You can create a new HTML template for this page with a success message.
    }

    @GetMapping("/verificationError")
    public String verificationError() {
        return "verificationError"; // You can create a new HTML template for this page with an error message.
    }

    @GetMapping("/verify")
    public String verifyEmail(@RequestParam("token") String verificationToken) {
        boolean isVerified = registrationService.verifyEmail(verificationToken);

        if (isVerified) {

            return "redirect:/verificationSuccess";
        } else {

            return "redirect:/verificationError";
        }
    }


}


