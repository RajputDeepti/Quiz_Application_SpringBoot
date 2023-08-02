package com.Spring.Quiz_Application.service;

import com.Spring.Quiz_Application.entity.Questions;
import com.Spring.Quiz_Application.entity.Quiz;
import com.Spring.Quiz_Application.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {
    @Autowired
    private QuestionsRepository questionsRepository;

    public List<Questions> getQuestionsForQuiz(Quiz quiz) {
        return questionsRepository.findByQuiz(quiz);
    }

    public Questions createQuestion(String questionText, String answer, Quiz quiz) {
        Questions question = new Questions();
        question.setText(questionText);
        question.setAnswer(answer);
        question.setQuiz(quiz);
        return questionsRepository.save(question);
    }
}
