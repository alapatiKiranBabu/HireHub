package com.hirehub.hirehub.repository;

import com.hirehub.hirehub.enums.JobType;
import com.hirehub.hirehub.model.PostJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostJobRepository extends JpaRepository<PostJob, Integer> {
    List<PostJob> findByJobTitleContainingAndLocationContainingAndJobType(String jobTitle, String jobLocation, JobType jobType);

    List<PostJob> findByJobTitleContainingAndLocationContaining(String jobTitle, String jobLocation);

    List<PostJob> findByJobTitleContainingAndJobType(String jobTitle, JobType jobType);

    List<PostJob> findByLocationContainingAndJobType(String jobLocation, JobType jobType);

    List<PostJob> findByJobTitleContaining(String jobTitle);

    List<PostJob> findByLocationContaining(String jobLocation);

    Optional<PostJob> findById(Integer id);

    List<PostJob> findByJobType(JobType jobType);
}
