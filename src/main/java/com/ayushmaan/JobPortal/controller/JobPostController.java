package com.ayushmaan.JobPortal.controller;

import com.ayushmaan.JobPortal.model.JobPost;
import com.ayushmaan.JobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobPostController {

    @Autowired
    private JobService jobService;

    @GetMapping("/getJobPosts")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    @PostMapping("/addJobPost")
    public String addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return "Added Successfully";
    }
}
