package com.Spring.Quiz_Application.service;

import com.Spring.Quiz_Application.Dto.SignUpPageDto;
import com.Spring.Quiz_Application.entity.User;
import com.Spring.Quiz_Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private UserRepository userRepository;
@Autowired
   private PasswordEncoder passwordEncoder;
    public String register(SignUpPageDto signUpPageDto)
    {
       User user = new User();
       user.setActive(true);
       user.setEmail(signUpPageDto.getEmail());
       user.setName(signUpPageDto.getName());
       user.setPassword(passwordEncoder.encode(signUpPageDto.getPassword()));
       user.setRole(signUpPageDto.getRole());

       userRepository.save(user);


        // Redirect to a success page or login page
        return "home";
    }}

