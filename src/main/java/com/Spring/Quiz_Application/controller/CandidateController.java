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
    public ModelAndView showNextQuestion(
            @RequestParam("quizKey") String quizKey,
            @RequestParam(value = "currentQuestionIndex", defaultValue = "0") int currentQuestionIndex,
            @RequestParam(value = "selectedOption", required = false) String selectedOption,
            @RequestParam(value = "timeTaken", required = false) Integer timeTaken,
            Model model) {
        Quiz quiz = quizService.getQuizByQuizKey(quizKey);
        if (quiz == null) {
            model.addAttribute("errorMessage", "Quiz key not found. Please enter a valid quiz key.");
            return new ModelAndView("AttemptQuiz");
        }

        if (currentQuestionIndex >= 0 && currentQuestionIndex < quiz.getQuestions().size()) {
            Question question = quiz.getQuestions().get(currentQuestionIndex);
            question.setSelectedOption(selectedOption);
            if (timeTaken != null) {
                question.setTime_taken(timeTaken.intValue());
            }
            quizService.saveSelectedAnswerAndTime(question);
        }

        quizService.saveQuiz(quiz);

        model.addAttribute("quizKey", quizKey);
        model.addAttribute("quiz", quiz);
        model.addAttribute("questions", quiz.getQuestions());
        model.addAttribute("currentQuestionIndex", currentQuestionIndex);

        System.out.println("Selected Option: " + selectedOption);
        System.out.println("Time Taken: " + timeTaken);


        return new ModelAndView("Attempt_quiz_form");
    }
    @PostMapping("/submit-quiz")
    public ModelAndView submitQuiz(@ModelAttribute("quiz") Quiz quiz) {
        //quizService.submitQuiz(quiz);
        return new ModelAndView("quiz_submitted");
    }
}
