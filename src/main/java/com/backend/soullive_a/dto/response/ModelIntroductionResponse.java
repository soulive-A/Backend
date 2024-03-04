package com.backend.soullive_a.dto.response;

import com.backend.soullive_a.entity.model.introduction.ModelImageKeyword;
import com.backend.soullive_a.entity.model.introduction.ModelRecentAdvertisement;
import com.backend.soullive_a.entity.model.introduction.ModelRecentWork;
import lombok.Builder;

import java.util.List;

@Builder
public record ModelIntroductionResponse(
        List<ModelImageKeyword> modelImageKeywords,
        List<ModelRecentWork> modelRecentWorks,
        List<ModelRecentAdvertisement> modelRecentAdvertisements
) {
}
