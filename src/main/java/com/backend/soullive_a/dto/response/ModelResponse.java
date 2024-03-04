package com.backend.soullive_a.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ModelResponse(
        Long modelId,
        String modelName,
        LocalDateTime birth,
        String job,
        String info,
        String agency,
        Float aiRate

) {}
