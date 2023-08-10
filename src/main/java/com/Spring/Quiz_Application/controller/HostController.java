package com.Spring.Quiz_Application.controller;

import com.Spring.Quiz_Application.entity.Question;
import com.Spring.Quiz_Application.entity.Quiz;
import com.Spring.Quiz_Application.service.HostService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/host")
public class HostController {
    @Autowired
    private HostService hostService;




    @GetMapping("/create-quiz")
    public ModelAndView showCreateQuizForm(Model model) {
        Quiz quiz = new Quiz();
        for (int i = 0; i < 10; i++) {
            quiz.getQuestions().add(new Question());
        }
        model.addAttribute("quiz", quiz);
        return new ModelAndView("create_quiz_form");
    }

    @PostMapping("/create-quiz")
    public ModelAndView createQuiz(Quiz quiz) {
        for (Question question : quiz.getQuestions()) {
            question.setQuiz(quiz); // Set the quiz for each question
        }

        hostService.createQuiz(quiz);
        return new ModelAndView("redirect:/host/create-quiz?success");
    }

    @GetMapping("/quiz/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable String key){
        Quiz quiz = hostService.getQuizById(key);

        if(quiz !=null){
            return ResponseEntity.ok(quiz);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

}
