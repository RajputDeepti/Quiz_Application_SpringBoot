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
@Table(name = "Host_Details")
public class Host {
    @Id
    @GeneratedValue
    private long hostId;
    private String name;
    private String email;
    private String password;
    private String role;
    private boolean active;
}
