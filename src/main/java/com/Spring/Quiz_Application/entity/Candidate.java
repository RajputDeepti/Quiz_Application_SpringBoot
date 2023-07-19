package com.Spring.Quiz_Application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Candidate_Details")
public class Candidate {
    @Id
    private long candidateId;
    private String candidateName;
}
