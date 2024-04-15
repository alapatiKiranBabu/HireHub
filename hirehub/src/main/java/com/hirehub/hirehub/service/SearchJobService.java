package com.hirehub.hirehub.service;
import com.hirehub.hirehub.DTO.SearchJobRequest;
import com.hirehub.hirehub.enums.JobType;
import com.hirehub.hirehub.model.PostJob;
import com.hirehub.hirehub.repository.PostJobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SearchJobService {

    private final PostJobRepository postJobRepository;

    public  List<PostJob> searchJob(String jobTitle, JobType jobType, String jobLocation){

        List<PostJob> availableJobs;

        if (jobTitle != null && !jobTitle.isEmpty() && jobLocation != null && !jobLocation.isEmpty() && jobType != null) {
            availableJobs = postJobRepository.findByJobTitleContainingAndLocationContainingAndJobType(jobTitle, jobLocation, jobType);
        } else if (jobTitle != null && !jobTitle.isEmpty() && jobLocation != null && !jobLocation.isEmpty()) {
            availableJobs = postJobRepository.findByJobTitleContainingAndLocationContaining(jobTitle, jobLocation);
        } else if (jobTitle != null && !jobTitle.isEmpty() && jobType != null) {
            availableJobs = postJobRepository.findByJobTitleContainingAndJobType(jobTitle, jobType);
        } else if (jobLocation != null && !jobLocation.isEmpty() && jobType != null) {
            availableJobs = postJobRepository.findByLocationContainingAndJobType(jobLocation, jobType);
        } else if (jobTitle != null && !jobTitle.isEmpty()) {
            availableJobs = postJobRepository.findByJobTitleContaining(jobTitle);
        } else if (jobLocation != null && !jobLocation.isEmpty()) {
            availableJobs = postJobRepository.findByLocationContaining(jobLocation);
        } else if (jobType != null) {
            availableJobs = postJobRepository.findByJobType(jobType);
        } else {
            // Handle the case when all parameters are null or empty
            availableJobs = new ArrayList<>();
        }
        System.out.println(availableJobs.size());
        return availableJobs;


    }
}

