package com.Spring.Quiz_Application.controller;

import com.Spring.Quiz_Application.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
=======
>>>>>>> 006a8b5436a64585d5489f7cd2b61227fd2e6bde
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

}
