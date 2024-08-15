package com.ayushmaan.JobPortal.service;

import com.ayushmaan.JobPortal.model.JobPost;
import com.ayushmaan.JobPortal.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public boolean updateJob(int id, JobPost update) {
        Optional<JobPost> job = repo.findById(id);
        if(job.isPresent()){
            repo.save(update);
            return true;
        }else return false;
    }
}
