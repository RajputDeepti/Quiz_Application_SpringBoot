package com.Spring.Quiz_Application.repository;

import com.Spring.Quiz_Application.entity.Candidate;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate,Long> {
}
