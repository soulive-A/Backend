package com.backend.soullive_a.service;

import com.backend.soullive_a.dto.response.ModelIntroductionResponse;

import java.util.List;

public interface ModelIntroductionService {
    public ModelIntroductionResponse getModelIntroduction(Long modelId);

}
