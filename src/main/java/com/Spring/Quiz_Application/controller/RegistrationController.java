package com.Spring.Quiz_Application.controller;


import com.Spring.Quiz_Application.Dto.UserDto;
import com.Spring.Quiz_Application.entity.Candidate;
import com.Spring.Quiz_Application.entity.Host;
import com.Spring.Quiz_Application.repository.CandidateRepository;
import com.Spring.Quiz_Application.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
    public class RegistrationController {

        @Autowired
        private CandidateRepository candidateRepository;

        @Autowired
        private HostRepository hostRepository;

        @GetMapping("/register")
        public String showRegistrationForm(Model model) {
            model.addAttribute("user", new UserDto()); // Create a UserDto class to hold the form data
            return "SignupForm";
        }

        @PostMapping("/registration")
        public String processRegistrationForm(@ModelAttribute("user") UserDto userDto) {
            if ("candidate".equals(userDto.getRole())) {
                Candidate candidate = new Candidate();
                // Set candidate-specific fields from the userDto
                candidate.setName(userDto.getName());
                candidate.setEmail(userDto.getEmail());
                candidate.setPassword(userDto.getPassword());
                // Save the candidate to the candidate repository
                candidateRepository.save(candidate);
            } else if ("host".equals(userDto.getRole())) {
                Host host = new Host();
                // Set host-specific fields from the userDto
                host.setName(userDto.getName());
                host.setEmail(userDto.getEmail());
                host.setPassword(userDto.getPassword());
                // Save the host to the host repository
                hostRepository.save(host);
            }
            // Redirect to a success page or login page
            return "home";
        }
    }


