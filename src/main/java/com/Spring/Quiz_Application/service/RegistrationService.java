package com.Spring.Quiz_Application.service;

import com.Spring.Quiz_Application.Dto.SignUpPageDto;
import com.Spring.Quiz_Application.entity.Candidate;
import com.Spring.Quiz_Application.entity.Host;
import com.Spring.Quiz_Application.repository.CandidateRepository;
import com.Spring.Quiz_Application.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private HostRepository hostRepository;

    public String register(SignUpPageDto signUpPageDto)
    {
        if ("candidate".equals(signUpPageDto.getRole())) {
            Candidate candidate = new Candidate();
            candidate.setActive(true);
            candidate.setRole("Candidate");
            // Set candidate-specific fields from the userDto
            candidate.setName(signUpPageDto.getName());
            candidate.setEmail(signUpPageDto.getEmail());
            candidate.setPassword(signUpPageDto.getPassword());
            // Save the candidate to the candidate repository
            candidateRepository.save(candidate);
        } else if ("host".equals(signUpPageDto.getRole())) {
            Host host = new Host();
            host.setActive(true);
            host.setRole("Host");
            // Set host-specific fields from the userDto
            host.setName(signUpPageDto.getName());
            host.setEmail(signUpPageDto.getEmail());
            host.setPassword(signUpPageDto.getPassword());
            // Save the host to the host repository
            hostRepository.save(host);
        }
        // Redirect to a success page or login page
        return "home";
    }
}
