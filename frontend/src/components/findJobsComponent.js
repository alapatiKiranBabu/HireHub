import React, { useState } from "react";
import axios from 'axios';
import './findJobComponent.css';
const FindJobsComponent = () => {
    const [searchData, setSearchData] = useState({
        jobTitle: "",
        jobType: "",
        jobLocation: "",
    });

    const [searchResults, setSearchResults] = useState([]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setSearchData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.get(`http://localhost:8082/find-jobs?jobTitle=${searchData.jobTitle}&jobType=${searchData.jobType}&location=${searchData.jobLocation}`)
            .then(response => {
                console.log("Search results:", response.data);
                setSearchResults(response.data.postJobList); // Set search results in state
            })
            .catch(error => {
                console.error("Error searching for jobs:", error);
                // Add your logic here to handle error
            });
        setSearchData({
            jobTitle: "",
            jobType: "",
            jobLocation: ""
        });
    };

    return (
        <div className="find-jobs-container">
            <h1>Find Jobs</h1>
            <div className="find-jobs-form">
                <form onSubmit={handleSubmit}>
                    <label>Job Title</label>
                    <input
                        type="text"
                        name="jobTitle"
                        value={searchData.jobTitle}
                        onChange={handleChange}
                    />
                    <label>Job Type</label>
                    <select
                        name="jobType"
                        value={searchData.jobType}
                        onChange={handleChange}
                    >
                        <option value="">Select Job Type</option>
                        <option value="FULL_TIME">Full Time</option>
                        <option value="PART_TIME">Part Time</option>
                        <option value="INTERNSHIP">Internship</option>
                    </select>
                    <label>Location</label>
                    <input
                        type="text"
                        name="jobLocation"
                        value={searchData.jobLocation}
                        onChange={handleChange}
                    />
                    <button type="submit">Search</button>
                </form>
            </div>
            
            {/* Display search results */}
            <div className="search-results-container">
                {searchResults.map((job, index) => (
                    <div className="job-card" key={index}>
                        <h2>{job.jobTitle}</h2>
                        <p>Job Type: {job.jobType}</p>
                        <p>Location: {job.location}</p>
                        <p>Job Description: {job.jobDescription}</p>
                        <p>Valid Till: {job.validTill}</p>
                        {/* Add more details if needed */}
                    </div>
                ))}
            </div>
        </div>
    );
};

export default FindJobsComponent;
