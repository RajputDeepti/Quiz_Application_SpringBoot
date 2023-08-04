package com.Spring.Quiz_Application.controller;

import com.Spring.Quiz_Application.entity.Quiz;
import com.Spring.Quiz_Application.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HostController {
    @Autowired
    private HostService hostService;
    @PostMapping("/createQuiz")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz)
    {
        Quiz quiz1 = hostService.createQuiz(quiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(quiz1);
    }

    @GetMapping("/quiz/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id){
        Quiz quiz = hostService.getQuizById(id);

        if(quiz !=null){
            return ResponseEntity.ok(quiz);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<Quiz>> getAllQuiz(){
        List<Quiz> quiz= hostService.getAllQuiz();
        return ResponseEntity.ok(quiz);
    }
}
