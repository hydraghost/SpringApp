package com.telusko.jobapp.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.jobapp.model.*;
import com.telusko.jobapp.repo.JobRepo;



@Service

public class JobService {
    @Autowired
    JobRepo jobRepo;

    public void addJob(JobPost jobpost){
       
       jobRepo.save(jobpost);

    }

    public List<JobPost> getAllJobs(){
            return jobRepo.findAll();

    }

    public JobPost getJob(int postId) {
        return jobRepo.findById(postId).orElse(new JobPost());    
    }

    public String updateJobPost(JobPost jobPost){
        // System.out.println(jobPost);
        jobRepo.save(jobPost);
        return "Updated";

    }


    public void deleteJobPost(int postId){
        jobRepo.deleteById(postId);
    
    }

    public void load() {
        List <JobPost> jobs=new ArrayList<>(List.of(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,List.of("Core Java", "J2EE", "Spring Boot", "Hibernate"))));
        jobRepo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }

    

}
