package com.hirehub.hirehub.service;

import com.hirehub.hirehub.DTO.PostJobRequest;
import com.hirehub.hirehub.model.PostJob;
import com.hirehub.hirehub.repository.PostJobRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostJobService {

    private final PostJobRepository postJobRepository;

    public void postJob(PostJobRequest postJobRequest){

        PostJob post = new PostJob();

        post.setCompanyWebsite(postJobRequest.getCompanyWebsite());
        post.setJobDescription(postJobRequest.getJobDescription());
        post.setJobTitle(postJobRequest.getJobTitle());
        post.setLocation(postJobRequest.getLocation());
        post.setValidTill(postJobRequest.getValidTill());
        post.setJobType(postJobRequest.getJobType());

        postJobRepository.save(post);
    }
}
