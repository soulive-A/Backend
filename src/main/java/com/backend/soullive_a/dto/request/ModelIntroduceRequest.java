package com.backend.soullive_a.dto.request;

import com.backend.soullive_a.entity.model.introduction.ModelImageKeyword;
import com.backend.soullive_a.entity.model.introduction.ModelRecentAdvertisement;
import com.backend.soullive_a.entity.model.introduction.ModelRecentWork;

import java.util.List;

public record ModelIntroduceRequest(
        List<String> keywords,
        List<ModelRecentWorkRequest> modelRecentWorks,
        List<ModelRecentAdvertisementRequest> modelRecentAdvertisements) {
}
