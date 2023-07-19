package com.Spring.Quiz_Application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Host_Details")
public class Host {
    @Id
    private long hostId;
    private String hostName;
}
