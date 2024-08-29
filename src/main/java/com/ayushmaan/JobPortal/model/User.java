package com.ayushmaan.JobPortal.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {
    @Id
    private int id;
    private String username;
    private String password;
    private String role;
    private List<String> authLevel;
    private List<JobPost> jobsApplied = new ArrayList<>();

}
