package com.backend.soullive_a.dto.response.model.popularity;

import com.backend.soullive_a.constant.AgeType;

public record ModelPopularAgeResponse(
        Long ageId,
        AgeType ageType
) {
}
