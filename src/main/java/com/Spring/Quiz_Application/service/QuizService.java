package com.Spring.Quiz_Application.service;

import com.Spring.Quiz_Application.entity.Quiz;
import com.Spring.Quiz_Application.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz getQuizByQuizKey(String quizKey) {

        return quizRepository.findByQuizKey(quizKey);
    }
    public void submitQuiz(Quiz quiz){


    }
}
