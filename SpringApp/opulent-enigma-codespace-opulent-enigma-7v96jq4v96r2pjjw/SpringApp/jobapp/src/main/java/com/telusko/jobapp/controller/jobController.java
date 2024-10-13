package com.telusko.jobapp.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.jobapp.model.JobPost;
import com.telusko.jobapp.service.JobService;

import jakarta.servlet.http.HttpServletRequest;


@RestController
// @CrossOrigin(origins = "https://opulent-enigma-7v96jq4v96r2pjjw-3000.app.github.dev")
public class jobController {
    @Autowired
    JobService jobService;

    @GetMapping("/")
    public String home(HttpServletRequest request){
        System.out.println("from home page");
        return "Welcome to JobApp" + request.getSession().getId();
    }

    @GetMapping("jobPosts") 
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    // @GetMapping("jobPost/{postId}")
    // public JobPost getJobPost(@PathVariable("postId") int postId){
    //     return jobService.getJob(postId);
    // }


    // @GetMapping("jobPosts/{keyword}")
    // public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
    //     return jobService.search(keyword);
    // }
    


    // @PostMapping("jobPost")
    // public String addJob(@RequestBody JobPost jobPost){
    //     jobService.addJob(jobPost);
    //     return "Success";
    // }

    // @PutMapping("jobPost")
    // public JobPost updateJobPost(@RequestBody JobPost jobPost){
    //     jobService.updateJobPost(jobPost);
    //     return jobService.getJob(jobPost.getPostId());
    // }

    // @DeleteMapping("jobPost/{postId}")
    // public String deleteJobPost(@PathVariable("postId") int postId){
    //     jobService.deleteJobPost(postId);
    //     return "Deleted";
    // }

    // @GetMapping("load")
    // public String loadData(){
    //     jobService.load();
    //     return "Success";
    // }

    // @GetMapping({"/","home"})
    // public String home(){
    //     System.out.println("Hello from home");
    //     return "home";
    // }
    // @GetMapping("addjob")
    // public String addjob(){
    //     System.out.println("Hello from addjob");
    //     return "addjob";
    // }

    // @PostMapping("handleForm")
    // public String handleForm(JobPost jobPost, Model model){

    //     System.out.println("Hello from handleForm");
    //     System.out.println(jobPost.getPostTechStack());
    //     jobService.addJob(jobPost);
    //     return "success";
    // }

    // @GetMapping("viewalljobs")
    // public String viewalljobs(Model model){
    //     System.out.println("Hello from viewalljobs");
    //     List<JobPost> jobs=jobService.getAllJobs();
    //     model.addAttribute("jobPosts", jobs);
    //     System.out.println(jobs);
    //     return "viewalljobs";
    // }
}
