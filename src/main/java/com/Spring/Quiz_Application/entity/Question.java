package com.Spring.Quiz_Application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Question")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long quesId;



    @NotBlank
    private String question;



    @NotBlank
    private String option1;



    @NotBlank
    private String option2;



    @NotBlank
    private String option3;



    @NotBlank
    private String option4;



    @NotBlank
    private String ans;



    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
