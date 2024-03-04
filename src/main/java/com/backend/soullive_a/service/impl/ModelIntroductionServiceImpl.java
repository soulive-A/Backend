package com.backend.soullive_a.service.impl;

import com.backend.soullive_a.dto.response.ModelImageKeywordResponse;
import com.backend.soullive_a.dto.response.ModelIntroductionResponse;
import com.backend.soullive_a.entity.model.introduction.ModelRecentAdvertisement;
import com.backend.soullive_a.entity.model.introduction.ModelRecentWork;
import com.backend.soullive_a.repository.ModelImageKeywordRepository;
import com.backend.soullive_a.repository.ModelRecentAdvertisementRepository;
import com.backend.soullive_a.repository.ModelRecentWorkRepository;
import com.backend.soullive_a.service.ModelIntroductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelIntroductionServiceImpl implements ModelIntroductionService {

    private final ModelImageKeywordRepository modelImageKeywordRepository;
    private final ModelRecentWorkRepository modelRecentWorkRepository;
    private final ModelRecentAdvertisementRepository modelRecentAdvertisementRepository;


    /**
     * 모델 소개 조회 서비스 로직
     * @param modelId
     * @return
     */
    @Override
    public ModelIntroductionResponse getModelIntroduction(Long modelId) {
        return ModelIntroductionResponse.builder()
                .modelImageKeywords(modelImageKeywordRepository.findAllById(modelId))
                .modelRecentWorks(modelRecentWorkRepository.findAllById(modelId))
                .modelRecentAdvertisements(modelRecentAdvertisementRepository.findAllById(modelId))
                .build();
    }

}
