package com.backend.soullive_a.dto.request;

import com.backend.soullive_a.entity.model.Model;

public record ModelRecentAdvertisementRequest(
        Long id,
        Integer year,
        String brand,
        Model model
) {
}
