package com.backend.soullive_a.dto.response.model.popularity;

public record ModelScheduledWorkResponse(
        Long modelScheduledWorkId,
        String imageUrl,
        Integer year,
        String category,
        String title,
        Boolean isMainActor,
        String genre
) {
}
