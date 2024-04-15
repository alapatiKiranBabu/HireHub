package com.hirehub.hirehub.controller;

import com.hirehub.hirehub.DTO.PostJobRequest;
import com.hirehub.hirehub.DTO.SearchJobRequest;
import com.hirehub.hirehub.DTO.SearchJobResponse;
import com.hirehub.hirehub.enums.JobType;
import com.hirehub.hirehub.model.PostJob;
import com.hirehub.hirehub.repository.PostJobRepository;
import com.hirehub.hirehub.service.PostJobService;
import com.hirehub.hirehub.service.SearchJobService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
@AllArgsConstructor
public class HireHubController {

    private final PostJobService postJobService;

    private final SearchJobService searchJobService;

    @PostMapping("/post-job")
    @CrossOrigin
    public ResponseEntity<String> postJob(@RequestBody PostJobRequest postJobRequest){

        postJobService.postJob(postJobRequest);

        return ResponseEntity.ok("Job has been posted successfully");
    }


    @GetMapping("/find-jobs")
    @CrossOrigin
    public ResponseEntity<SearchJobResponse> postJob( @RequestParam(value = "jobTitle", required = false) String jobTitle,
                                                      @RequestParam(value = "jobType", required = false) JobType jobType,
                                                      @RequestParam(value = "location", required = false) String location){

        List<PostJob> availableJobs = searchJobService.searchJob(jobTitle, jobType, location);

        SearchJobResponse searchJobResponse = SearchJobResponse
                                             .builder()
                                             .postJobList(availableJobs)
                                             .build();

        return ResponseEntity.ok(searchJobResponse);
    }
}
