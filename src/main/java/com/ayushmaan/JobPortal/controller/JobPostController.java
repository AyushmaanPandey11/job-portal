package com.ayushmaan.JobPortal.controller;

import com.ayushmaan.JobPortal.model.JobPost;
import com.ayushmaan.JobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job")
@CrossOrigin(origins = "http://localhost:3000")
public class JobPostController {

    @Autowired
    private JobService jobService;

    @GetMapping("/getJobPosts")
    public ResponseEntity<List<JobPost>> getAllJobs(){
        List<JobPost> jobs = jobService.getAllJobs();
        if (jobs != null){
            return new ResponseEntity<>(jobs, HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPost> getJobById(@PathVariable("id") int id){
        JobPost job = jobService.getJob(id);
        if(job!=null){
            return new ResponseEntity<>(job, HttpStatus.ACCEPTED);
        }
        else return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getByKeyword/{keyword}")
    public ResponseEntity<List<JobPost>> getJobByKeyword(@PathVariable("keyword") String keyword){
        List<JobPost> result = jobService.searchByKeyword(keyword);
        if (result != null){
            return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addJobPost")
    public ResponseEntity<JobPost> addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return new ResponseEntity<>(jobPost,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deletedById(@PathVariable("id") int id){
        jobService.deleteJob(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateJob(@PathVariable("id") int id, @RequestBody JobPost update){

        boolean isUpdated = jobService.updateJob(id,update);
        if(isUpdated){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
