package com.backend.soullive_a.dto.response;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record ModelResponse(
        Long modelId,
        String imageUrl,
        String modelName,
        LocalDate birth,

        String age,

        String job,
        String info,
        String agency,
        Float aiRate

) {}
