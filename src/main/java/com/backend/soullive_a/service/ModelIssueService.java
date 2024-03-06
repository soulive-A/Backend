package com.backend.soullive_a.service;


import com.backend.soullive_a.dto.response.model.issue.ModelIssueResponse;

public interface ModelIssueService {
    public ModelIssueResponse getIssue(String name);
}
