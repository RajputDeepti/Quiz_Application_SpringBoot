package com.Spring.Quiz_Application.controller;

import com.Spring.Quiz_Application.entity.Question;
import com.Spring.Quiz_Application.entity.Quiz;
import com.Spring.Quiz_Application.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.time.Duration;
import java.time.Instant;
import java.util.List;


@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private QuizService quizService;
    @GetMapping("/attemptQuiz")
    public ModelAndView showAttemptQuizForm(Model model){
        model.addAttribute("quizKey","");
        return new ModelAndView("AttemptQuiz");
    }}
