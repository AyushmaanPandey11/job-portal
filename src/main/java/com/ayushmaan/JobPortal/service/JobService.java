package com.ayushmaan.JobPortal.service;

import com.ayushmaan.JobPortal.model.JobPost;
import com.ayushmaan.JobPortal.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost job){
        repo.addJob(job);
    }
    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
    }
}
