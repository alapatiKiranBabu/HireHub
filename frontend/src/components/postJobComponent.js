import React, { useState } from 'react';
import axios from 'axios';
import './JobComponent.css'; // Corrected import path

const PostJobsComponent = () => {
    const [jobFormData, setJobFormData] = useState({
        jobTitle: "",
        jobType: "FULL_TIME",
        jobLocation: "",
        validTill: "",
        jobDescription: "",
        companyWebsite: ""
    });

    const [postedJob, setPostedJob] = useState(null);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setJobFormData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8082/post-job', jobFormData)
            .then(response => {
                console.log("Job posted successfully:", response.data);
                setPostedJob(response.data); // Set posted job information
            })
            .catch(error => {
                console.error("Error posting job:", error);
                // Add your logic here to handle error
            });
    };

    return (
        <div className="post-jobs-container">
            <h1>Post Job</h1>
            <div className="post-jobs-form">
                <form onSubmit={handleSubmit}>
                    <label>Job Title</label>
                    <input
                        type="text"
                        name="jobTitle"
                        value={jobFormData.jobTitle}
                        onChange={handleChange}
                    />
                    <label>Job Type</label>
                    <select
                        name="jobType"
                        value={jobFormData.jobType}
                        onChange={handleChange}
                    >
                        <option value="FULL_TIME">Full Time</option>
                        <option value="PART_TIME">Part Time</option>
                        <option value="INTERNSHIP">Internship</option>
                    </select>
                    <label>Job Location</label>
                    <input
                        type="text"
                        name="jobLocation"
                        value={jobFormData.jobLocation}
                        onChange={handleChange}
                    />
                    <label>Valid Till</label>
                    <input
                        type="date"
                        name="validTill"
                        value={jobFormData.validTill}
                        onChange={handleChange}
                    />
                    <label>Job Description</label>
                    <input
                        type="text"
                        name="jobDescription"
                        value={jobFormData.jobDescription}
                        onChange={handleChange}
                    />
                    <label>Company Website</label>
                    <input
                        type="text"
                        name="companyWebsite"
                        value={jobFormData.companyWebsite}
                        onChange={handleChange}
                    />
                    <button type="submit">Submit</button>
                </form>
            </div>

            {/* Display posted job information */}
            {postedJob && (
                <div className="posted-job-container">
                    <h2>Job Posted Successfully</h2>
                    <div className="posted-job-details">
                        <p><strong>Job Title:</strong> {postedJob.jobTitle}</p>
                        <p><strong>Job Type:</strong> {postedJob.jobType}</p>
                        <p><strong>Location:</strong> {postedJob.jobLocation}</p>
                        <p><strong>Valid Till:</strong> {postedJob.validTill}</p>
                        <p><strong>Job Description:</strong> {postedJob.jobDescription}</p>
                        <p><strong>Company Website:</strong> {postedJob.companyWebsite}</p>
                    </div>
                </div>
            )}
        </div>
    );
};

export default PostJobsComponent;
