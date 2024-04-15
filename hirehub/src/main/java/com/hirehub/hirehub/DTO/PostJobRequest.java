package com.hirehub.hirehub.DTO;

import com.hirehub.hirehub.enums.JobType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostJobRequest {
    private String companyWebsite;
    private  String jobTitle;
    private JobType jobType;
    private String location;
    private Date validTill;
    private String jobDescription;
}
