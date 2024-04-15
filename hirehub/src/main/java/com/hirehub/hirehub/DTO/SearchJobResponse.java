package com.hirehub.hirehub.DTO;

import com.hirehub.hirehub.enums.JobType;
import com.hirehub.hirehub.model.PostJob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchJobResponse {
    private List<PostJob> postJobList;
}