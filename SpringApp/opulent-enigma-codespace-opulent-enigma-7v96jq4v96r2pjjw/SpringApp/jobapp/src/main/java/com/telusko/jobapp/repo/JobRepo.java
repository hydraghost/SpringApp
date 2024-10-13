package com.telusko.jobapp.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.jobapp.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);

    
}


// List <JobPost> jobs=new ArrayList<>();

//     public JobRepo(){
//         jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//                     List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
//     }
//     public void addJobPost(JobPost job){
//         System.out.println("Job added to the repo");
//         System.out.println(job);
//         jobs.add(job);
//     }

//     public List<JobPost> returnAllJobs(){
//         return jobs;
//     }
//     public JobPost getJob(int postId) {
//         for(JobPost job:jobs){
//             if(job.getPostId()==postId){
//                 return job;
//             }
//         }
//         return null;

//     }
//     public void updateJobPost(JobPost jobPost) {
//         for(JobPost job:jobs){
//             System.out.println(job);
//             if(job.getPostId()==jobPost.getPostId()){
//                 System.out.println(job);
//                 job.setPostTechStack(jobPost.getPostTechStack());
//                 job.setPostDesc(jobPost.getPostDesc());
//                 job.setReqExperience(jobPost.getReqExperience());
//                 job.setPostProfile(jobPost.getPostProfile());
//             }
//         }
//     }
//     public JobPost deleteJobPost(int postId) {
//         for(JobPost job:jobs){
//             if(job.getPostId()==postId){
//                 jobs.remove(job);
//                 return job;
//             }
//         }
//         return null;
//     }