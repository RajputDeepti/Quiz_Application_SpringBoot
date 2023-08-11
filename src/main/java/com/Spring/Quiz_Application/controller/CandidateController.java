package com.Spring.Quiz_Application.controller;

import com.Spring.Quiz_Application.entity.Question;
import com.Spring.Quiz_Application.entity.Quiz;
import com.Spring.Quiz_Application.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class CandidateController {
    @Autowired
    private QuizService quizService;
    @GetMapping("/attemptQuiz")
    public ModelAndView showAttemptQuizForm(Model model){
        model.addAttribute("quizKey","");
        return new ModelAndView("AttemptQuiz");
    }
    @GetMapping("/attemptingQuiz")
    public ModelAndView showAttemptQuizForm(@RequestParam("quizKey") String quizKey, Model model) {
        Quiz quiz = quizService.getQuizByQuizKey(quizKey);
        if (quiz == null) {
            return new ModelAndView("quiz_not_found");
        }
        for (Question question : quiz.getQuestions()) {
            question.setSelectedOption(null); 
        }
        model.addAttribute("quizKey", quizKey);
        model.addAttribute("quiz", quiz);
        return new ModelAndView("Attempt_quiz_form");
    }

    @PostMapping("/submit-quiz")
    public ModelAndView submitQuiz(@ModelAttribute("quiz") Quiz quiz) {
        //quizService.submitQuiz(quiz);
        return new ModelAndView("quiz_submitted");
    }


}
