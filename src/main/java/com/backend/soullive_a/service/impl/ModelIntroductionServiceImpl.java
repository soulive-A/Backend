package com.backend.soullive_a.service.impl;

import com.backend.soullive_a.dto.request.ModelIntroduceRequest;
import com.backend.soullive_a.dto.request.ModelRecentAdvertisementRequest;
import com.backend.soullive_a.dto.request.ModelRecentWorkRequest;
import com.backend.soullive_a.dto.response.ModelImageKeywordResponse;
import com.backend.soullive_a.dto.response.ModelIntroductionResponse;
import com.backend.soullive_a.entity.model.Model;
import com.backend.soullive_a.entity.model.introduction.ModelImageKeyword;
import com.backend.soullive_a.entity.model.introduction.ModelIntroduction;
import com.backend.soullive_a.entity.model.introduction.ModelRecentAdvertisement;
import com.backend.soullive_a.entity.model.introduction.ModelRecentWork;
import com.backend.soullive_a.exception.custom.NotFoundUserException;
import com.backend.soullive_a.repository.*;
import com.backend.soullive_a.service.ModelIntroductionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
    public ModelIntroductionResponse getModelIntroduction(Long modelId) {
        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new NotFoundUserException());

        System.out.println(model.getModelName());
        List<ModelImageKeyword> modelImageKeywords = modelImageKeywordRepository.findAllByModel(model);

        List<ModelImageKeywordResponse> dtoList = modelImageKeywords.stream()
                .map(modelImageKeyword -> ModelImageKeywordResponse.builder()
                        .id(modelImageKeyword.getId())
                        .keyword(modelImageKeyword.getKeyword())
                        .model(modelImageKeyword.getModel())
                        .build())
                .collect(Collectors.toList());

//        List<ModelImageKeyword> modelImageKeywords2 = modelImageKeywords.stream()
//                .map(keyword -> new ModelImageKeyword(keyword.getId(), keyword.getKeyword(), keyword.getModel()))
//                .collect(Collectors.toList());

//        System.out.println("len"+modelImageKeywords2.size());
//        for (ModelImageKeyword keyword : modelImageKeywords2) {
//            System.out.println(keyword.getKeyword());
//        }

        return ModelIntroductionResponse.builder()
                .modelImageKeywords(dtoList)
                .modelRecentWorks(null)
                .modelRecentAdvertisements(null)
                .build();
//        return ModelIntroductionResponse.builder()
//                .modelImageKeywords(modelImageKeywordRepository.findAllById(modelId))
//                .modelRecentWorks(modelRecentWorkRepository.findAllById(modelId))
//                .modelRecentAdvertisements(modelRecentAdvertisementRepository.findAllById(modelId))
//                .build();
    }

    /**
     * 모델소개 생성 서비스 로직
     *
     * @param modelId
     * @return
     */
    @Override
    @Transactional
    public ModelIntroductionResponse createModelIntroduction(ModelIntroduceRequest request, Long modelId) {
        List<ModelImageKeyword> modelImageKeywordList = new ArrayList<>();
        List<ModelRecentWork> modelRecentWorkList = new ArrayList<>();
        List<ModelRecentAdvertisement> modelRecentAdvertisementList = new ArrayList<>();


        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new NotFoundUserException());

        ModelIntroduction modelIntroduction = modelIntroductionRepository.save(
                ModelIntroduction.builder()
                        .model(model)
                        .build()
        );

        // ModelImageKeyword 엔티티 각각 저장
        for (String keyword : request.keywords()) {
            ModelImageKeyword modelImageKeyword = ModelImageKeyword.builder()
                    .model(model)
                    .keyword(keyword)
                    .build();
            modelImageKeywordList.add(modelImageKeyword);
            modelImageKeywordRepository.save(modelImageKeyword);

        }

        // ModelRecentWorkRequest 엔티티 각각 저장
        for (ModelRecentWorkRequest modelRecentWorkRequest : request.modelRecentWorks()) {
            ModelRecentWork modelRecentWork = ModelRecentWork.builder()
                    .year(modelRecentWorkRequest.year())
                    .category(modelRecentWorkRequest.category())
                    .title(modelRecentWorkRequest.title())
                    .genre(modelRecentWorkRequest.genre())
                    .role(modelRecentWorkRequest.role())
                    .isMainActor(modelRecentWorkRequest.isMainActor())
                    .model(model)
                    .build();

            modelRecentWorkList.add(modelRecentWork);
            modelRecentWorkRepository.save(modelRecentWork);
        }

        // modelRecentAdvertisementRepository 엔티티 각각 저장
        for (ModelRecentAdvertisementRequest modelRecentAdvertisementRequest : request.modelRecentAdvertisements()) {
            ModelRecentAdvertisement modelRecentAdvertisement = ModelRecentAdvertisement.builder()
                    .year(modelRecentAdvertisementRequest.year())
                    .brand(modelRecentAdvertisementRequest.brand())
                    .model(model)
                    .build();

            modelRecentAdvertisementList.add(modelRecentAdvertisement);
            modelRecentAdvertisementRepository.save(modelRecentAdvertisement);
        }

        return ModelIntroductionResponse.builder()
                .modelImageKeywords(modelImageKeywordList)
                .modelRecentWorks(modelRecentWorkList)
                .modelRecentAdvertisements(modelRecentAdvertisementList)
                .build();

    }


}
