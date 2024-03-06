
package com.backend.soullive_a.service.impl;

import com.backend.soullive_a.dto.request.ModelIntroduceRequest;
import com.backend.soullive_a.dto.request.ModelRecentAdvertisementRequest;
import com.backend.soullive_a.dto.request.ModelRecentWorkRequest;
import com.backend.soullive_a.dto.response.ModelIntroductionResponse;
import com.backend.soullive_a.dto.response.ModelRecentAdvertisementResponse;
import com.backend.soullive_a.dto.response.ModelRecentWorkResponse;
import com.backend.soullive_a.entity.model.Model;
import com.backend.soullive_a.entity.model.introduction.ModelImageKeyword;
import com.backend.soullive_a.entity.model.introduction.ModelIntroduction;
import com.backend.soullive_a.entity.model.introduction.ModelRecentAdvertisement;
import com.backend.soullive_a.entity.model.introduction.ModelRecentWork;
import com.backend.soullive_a.exception.custom.NotFoundUserException;
import com.backend.soullive_a.repository.*;
import com.backend.soullive_a.repository.model.introduction.ModelImageKeywordRepository;
import com.backend.soullive_a.repository.model.introduction.ModelIntroductionRepository;
import com.backend.soullive_a.repository.model.introduction.ModelRecentAdvertisementRepository;
import com.backend.soullive_a.repository.model.introduction.ModelRecentWorkRepository;
import com.backend.soullive_a.service.ModelIntroductionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ModelIntroductionServiceImpl implements ModelIntroductionService {

    private final ModelImageKeywordRepository modelImageKeywordRepository;
    private final ModelRecentWorkRepository modelRecentWorkRepository;
    private final ModelRecentAdvertisementRepository modelRecentAdvertisementRepository;
    private final ModelRepository modelRepository;
    private final ModelIntroductionRepository modelIntroductionRepository;

    /**
     * 모델 소개 조회 서비스 로직
     *
     * @param modelId
     * @return
     */
    @Override
    public ModelIntroductionResponse getModelIntroduction(String modelName) {
        Model model = modelRepository.findByModelName(modelName)
                .orElseThrow(() -> new NotFoundUserException());

        List<ModelImageKeyword> modelImageKeywords = modelImageKeywordRepository.findAllByModel(model);
        List<ModelRecentWork> modelRecentWorks = modelRecentWorkRepository.findAllByModel(model);
        List<ModelRecentAdvertisement> modelRecentAdvertisements = modelRecentAdvertisementRepository.findAllByModel(model);

        List<String> modelImageKeywordResponse = new ArrayList<>();
        List<ModelRecentWorkResponse> modelRecentWorkResponse = new ArrayList<>();
        List<ModelRecentAdvertisementResponse> modelRecentAdvertisementResponse = new ArrayList<>();

        for (ModelImageKeyword keyword : modelImageKeywords) {
            modelImageKeywordResponse.add(keyword.getKeyword());
        }
        for (ModelRecentWork modelRecentWork : modelRecentWorks) {
            modelRecentWorkResponse.add(
                    ModelRecentWorkResponse.builder()
                            .imageUrl(modelRecentWork.getImageUrl())
                            .year(modelRecentWork.getYear())
                            .category(modelRecentWork.getCategory())
                            .title(modelRecentWork.getTitle())
                            .genre(modelRecentWork.getGenre())
                            .role(modelRecentWork.getRole())
                            .build()
            );
        }

        for (ModelRecentAdvertisement modelRecentAdvertisement : modelRecentAdvertisements) {
            modelRecentAdvertisementResponse.add(
                    ModelRecentAdvertisementResponse.builder()
                            .imageUrl(modelRecentAdvertisement.getImageUrl())
                            .year(modelRecentAdvertisement.getYear())
                            .brand(modelRecentAdvertisement.getBrand())
                            .build()
            );
        }

        return ModelIntroductionResponse.builder()
                .modelImageKeywords(modelImageKeywordResponse)
                .modelRecentWorks(modelRecentWorkResponse)
                .modelRecentAdvertisements(modelRecentAdvertisementResponse)
                .build();


    }


}

