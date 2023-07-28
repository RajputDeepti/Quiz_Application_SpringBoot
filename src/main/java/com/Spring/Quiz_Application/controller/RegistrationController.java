package com.Spring.Quiz_Application.controller;


import com.Spring.Quiz_Application.Dto.UserDto;
import com.Spring.Quiz_Application.entity.Candidate;
import com.Spring.Quiz_Application.entity.Host;
import com.Spring.Quiz_Application.repository.CandidateRepository;
import com.Spring.Quiz_Application.repository.HostRepository;
import jakarta.servlet.http.HttpSession;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
    public class RegistrationController {

        @Autowired
        private CandidateRepository candidateRepository;

        @Autowired
        private HostRepository hostRepository;



        @PostMapping("/registration")
        public String processRegistrationForm(@ModelAttribute("user") UserDto userDto, Model model) throws Exception {


           try {
               if ("candidate".equals(userDto.getRole())) {
                   Candidate candidate = new Candidate();
                   candidate.setActive(true);
                   candidate.setRole("candidate");
                   // Set candidate-specific fields from the userDto
                   candidate.setName(userDto.getName());
                   candidate.setEmail(userDto.getEmail());
                   candidate.setPassword(userDto.getPassword());
                   // Save the candidate to the candidate repository
                   candidateRepository.save(candidate);
               } else if ("host".equals(userDto.getRole())) {
                   Host host = new Host();
                   host.setActive(true);
                   host.setRole("host");
                   // Set host-specific fields from the userDto
                   host.setName(userDto.getName());
                   host.setEmail(userDto.getEmail());
                   host.setPassword(userDto.getPassword());
                   // Save the host to the host repository
                   hostRepository.save(host);
               }
               model.addAttribute("user",userDto);
               // Redirect to a success page or login page
               return "home";
           }
           catch (Exception e){
               e.printStackTrace();
               model.addAttribute("user",userDto);
               System.out.println("Something went wrong!!!");
               return "SignupForm";
           }
        }
    }


