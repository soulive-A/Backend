package com.backend.soullive_a.dto.response;

import com.backend.soullive_a.constant.AgeType;

public record AgeResponse(
        Long ageId,
        AgeType ageType
) {
}
