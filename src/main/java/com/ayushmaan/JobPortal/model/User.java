package com.ayushmaan.JobPortal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String role;
    @ElementCollection
    private List<String> authLevel;
    @ManyToMany
    @JoinTable(
            name = "user_jobpost",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "jobpost_id")
    )
    private List<JobPost> jobsApplied = new ArrayList<>();

}
