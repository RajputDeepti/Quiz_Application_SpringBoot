package com.Spring.Quiz_Application.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
import lombok.NonNull;
import org.hibernate.validator.constraints.UniqueElements;

=======
>>>>>>> 006a8b5436a64585d5489f7cd2b61227fd2e6bde

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpPageDto {
    @Email
    private String email;
    @Pattern(regexp = "^[A-Za-z]+$", message = "Field can not be empty and must contain alphabets only")
    private String name;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&*+=]).{8,}$", message = "Invalid password!! It should contain atleast one capital, one small letter alphabet, atleast one number and one special character")
    private String password;
    @NotBlank
    private String role;
    private String verificationToken;
    private boolean active;


}
