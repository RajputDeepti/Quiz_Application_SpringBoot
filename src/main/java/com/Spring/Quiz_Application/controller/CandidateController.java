package com.Spring.Quiz_Application.controller;

import com.Spring.Quiz_Application.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
}
