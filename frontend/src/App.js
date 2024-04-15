import React from "react";
import PostJobsComponent from "./components/postJobComponent";
import FindJobsComponent from "./components/findJobsComponent";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
      <div>
      <BrowserRouter>
        <Routes>
          <Route path="post-jobs" element={<PostJobsComponent />} />
          <Route path="find-jobs" element={<FindJobsComponent />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
