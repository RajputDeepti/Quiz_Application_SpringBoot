package com.Spring.Quiz_Application.controller;

import com.Spring.Quiz_Application.Dto.UserDto;
import com.Spring.Quiz_Application.repository.CandidateRepository;
import com.Spring.Quiz_Application.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private HostRepository hostRepository;


}
