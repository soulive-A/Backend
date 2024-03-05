package com.backend.soullive_a.dto.request;

public record ModelRecentWorkRequest(
        Integer year,
        String category,
        String title,
        String genre,
        String role,
        Boolean isMainActor
) {
}