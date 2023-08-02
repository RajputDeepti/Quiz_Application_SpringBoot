package com.Spring.Quiz_Application.repository;
import com.Spring.Quiz_Application.entity.Questions;
import com.Spring.Quiz_Application.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions,Long> {
    List<Questions> findByQuiz(Quiz quiz);
}
