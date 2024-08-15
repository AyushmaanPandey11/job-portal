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
        repo.save(job);
    }
    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int id) {
        return repo.findById(id).orElse(new JobPost());
    }

    public void deleteJob(int id){
        repo.deleteById(id);
    }

    public List<JobPost> searchByKeyword(String keyword){
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }

    public void updateJob( JobPost update) {
        repo.save(update);
    }
}
