package com.ayushmaan.JobPortal.repository;

import com.ayushmaan.JobPortal.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepo {
    public List<JobPost> getAllJobs(){
        return new ArrayList<>();
    }
    public void addJob(JobPost job){

    }
}
