package com.Spring.Quiz_Application.service;

import com.Spring.Quiz_Application.entity.Host;
import com.Spring.Quiz_Application.entity.Quiz;
import com.Spring.Quiz_Application.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz createQuiz(String quizName, Host host) {
        Quiz quiz = new Quiz();
        quiz.setName(quizName);
        quiz.setHost(host);
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long quizId) {
        return quizRepository.findById(quizId).orElse(null);
    }
}
