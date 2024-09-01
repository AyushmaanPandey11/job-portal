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
public class JobPost{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;
    @ManyToMany(mappedBy = "jobsApplied")
    private List<User> applicants = new ArrayList<>();
}
