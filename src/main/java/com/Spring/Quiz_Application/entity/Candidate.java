package com.Spring.Quiz_Application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Candidate_Details")
public class Candidate {
    @Id
    @GeneratedValue
    private long candidateId;
    private String email;
    private String name;
    private String password;
    private String role;
    private boolean active;
}
