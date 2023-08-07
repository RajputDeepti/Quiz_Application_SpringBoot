package com.Spring.Quiz_Application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "Quiz")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @NotBlank
    //@Column(unique = true, length =10)
    private String quizKey; // Changed the column name to "quizKey"



    @OneToMany(mappedBy = "quiz")
    private List<Question> questions;

}
