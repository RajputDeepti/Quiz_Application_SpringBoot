package com.Spring.Quiz_Application.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HostLoginDto {
    private String email;
    private String password;
}
