package com.Spring.Quiz_Application.controller;

import com.Spring.Quiz_Application.entity.Questions;
import com.Spring.Quiz_Application.entity.Quiz;
import com.Spring.Quiz_Application.service.QuestionsService;
import com.Spring.Quiz_Application.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private QuizService quizService;

    @PostMapping
    public ResponseEntity<Questions> createQuestion(@RequestBody Map<String, String> questionData) {
        String questionText = questionData.get("questionText");
        String answer = questionData.get("answer");
        Long quizId = Long.parseLong(questionData.get("quizId"));

        Quiz quiz = quizService.getQuizById(quizId);
        Questions newQuestion = questionsService.createQuestion(questionText, answer, quiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(newQuestion);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<List<Questions>> getQuestionsForQuiz(@PathVariable Long quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        List<Questions> questions = questionsService.getQuestionsForQuiz(quiz);
        return ResponseEntity.ok(questions);
    }
}