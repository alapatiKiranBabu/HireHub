package com.hirehub.hirehub.model;


import com.hirehub.hirehub.enums.JobType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "jobs")
public class PostJob {

    @Id
    @GeneratedValue
    private Integer id;

    private String companyWebsite;

    private  String jobTitle;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private String location;

    private Date validTill;

    private String jobDescription;

    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}
