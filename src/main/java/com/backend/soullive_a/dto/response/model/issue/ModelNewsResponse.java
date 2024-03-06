package com.backend.soullive_a.dto.response.model.issue;

import jakarta.persistence.Column;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ModelNewsResponse(
        String company,
        LocalDate newsDate,
        String title,
        String newsUrl
) {
}
