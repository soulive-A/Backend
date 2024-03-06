package com.backend.soullive_a.dto.response.model.popularity;

import com.backend.soullive_a.constant.GenderType;

public record ModelPopularGenderResponse(
        Long genderId,
        GenderType gender
) {
}
