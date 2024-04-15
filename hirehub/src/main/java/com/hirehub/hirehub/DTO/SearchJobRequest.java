package com.hirehub.hirehub.DTO;


import com.hirehub.hirehub.enums.JobType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchJobRequest {
    private  String jobTitle;
    private JobType jobType;
    private String location;
}
