package com.Spring.Quiz_Application.repository;

import com.Spring.Quiz_Application.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
}
