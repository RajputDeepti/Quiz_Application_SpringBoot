package com.Spring.Quiz_Application.controller;
import com.Spring.Quiz_Application.entity.Question;
import com.Spring.Quiz_Application.entity.Quiz;
import com.Spring.Quiz_Application.service.CreateQuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateQuizController {
    @Autowired
    private CreateQuizService createQuizService;

    @PostMapping("/creatingQuiz")
    public String processCreateQuiz(@ModelAttribute("quiz") @Valid Quiz quiz, BindingResult result){
        if(result.hasErrors()){
            System.out.println("ERROR: "+result.toString());
            return "CreateQuiz";
        }
        createQuizService.quizCreate(quiz);
        return "redirect:/AddQuestions";
    }

    @PostMapping("/addingQuestions")
    public String processAddQuestion(@ModelAttribute("ques") @Valid Question question, BindingResult result) {
        if(result.hasErrors()){
            System.out.println("ERROR: "+result.toString());
            return "CreateQuiz";
        }
        createQuizService.addQues(question);
        return "redirect:/host/dashboard";
    }
}
