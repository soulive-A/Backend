package com.backend.soullive_a.dto.response.model.issue;

import lombok.Builder;

import java.util.List;

@Builder
public record ModelIssueResponse(
        String scoreUrl,
        String aiComment,
        Integer crime,
        List<ModelNewsResponse> modelNewsResponseList
) {
}
