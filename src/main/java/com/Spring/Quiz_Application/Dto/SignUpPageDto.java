package com.Spring.Quiz_Application.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
}
