package com.Spring.Quiz_Application.service;

import com.Spring.Quiz_Application.entity.Question;
import com.Spring.Quiz_Application.entity.Quiz;
import com.Spring.Quiz_Application.repository.QuestionRepository;
import com.Spring.Quiz_Application.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateQuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;
    public void quizCreate(Quiz quiz) {
        Quiz quiz1= new Quiz();
        quiz1.setKey(quiz.getKey());
        quizRepository.save(quiz1);
    }

    public Question addQues(Question question) {
        Quiz quiz=quizRepository.findById(question.getQuiz().getId()).orElse(null);
        if(quiz==null)
        {
            throw new IllegalArgumentException("Quiz not found");
        }
        Question question1 = new Question();
        question1.setQuestion(question.getQuestion());
        question1.setOption1(question.getOption1());
        question1.setOption2(question.getOption2());
        question1.setOption3(question.getOption3());
        question1.setOption4(question.getOption4());
        question1.setAns(question.getAns());
        question1.setQuiz(question.getQuiz());

        return questionRepository.save(question1);
    }
}
