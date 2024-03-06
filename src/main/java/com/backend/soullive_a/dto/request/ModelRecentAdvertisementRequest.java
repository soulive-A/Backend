package com.backend.soullive_a.dto.request;


public record ModelRecentAdvertisementRequest(
        String imageUrl,

        Integer year,
        String brand
) {
}
