package com.Spring.Quiz_Application.controller;

import com.Spring.Quiz_Application.entity.Host;
import com.Spring.Quiz_Application.entity.Quiz;
import com.Spring.Quiz_Application.service.HostService;
import com.Spring.Quiz_Application.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class QuizController {
    @Autowired
    private QuizService quizService;
    @Autowired
    private HostService hostService;
    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Map<String, String> quizData) {
        String quizName = quizData.get("quizName");
        Long hostId = Long.parseLong(quizData.get("hostId"));

        Host host = hostService.getHostById(hostId);
        Quiz newQuiz = quizService.createQuiz(quizName, host);
        return ResponseEntity.status(HttpStatus.CREATED).body(newQuiz);
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }
}
