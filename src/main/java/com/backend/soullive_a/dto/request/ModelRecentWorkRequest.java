package com.backend.soullive_a.dto.request;

import com.backend.soullive_a.entity.model.Model;

public record ModelRecentWorkRequest(
        Integer year,
        String category,
        String title,
        String genre,
        String role,
        Boolean isMainActor
) {
}
