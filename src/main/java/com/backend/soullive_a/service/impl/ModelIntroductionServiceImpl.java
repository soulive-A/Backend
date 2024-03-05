//package com.backend.soullive_a.service.impl;
//
//import com.backend.soullive_a.dto.request.ModelIntroduceRequest;
//import com.backend.soullive_a.dto.response.ModelIntroductionResponse;
//import com.backend.soullive_a.entity.model.Model;
//import com.backend.soullive_a.entity.model.introduction.ModelImageKeyword;
//import com.backend.soullive_a.entity.model.introduction.ModelIntroduction;
//import com.backend.soullive_a.exception.custom.NotFoundUserException;
//import com.backend.soullive_a.repository.*;
//import com.backend.soullive_a.service.ModelIntroductionService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//
//@Service
//@RequiredArgsConstructor
//public class ModelIntroductionServiceImpl implements ModelIntroductionService {
//
//    private final ModelImageKeywordRepository modelImageKeywordRepository;
//    private final ModelRecentWorkRepository modelRecentWorkRepository;
//    private final ModelRecentAdvertisementRepository modelRecentAdvertisementRepository;
//    private final ModelRepository modelRepository;
//    private final ModelIntroductionRepository modelIntroductionRepository;
//
//    /**
//     * 모델 소개 조회 서비스 로직
//     * @param modelId
//     * @return
//     */
//    @Override
//    public ModelIntroductionResponse getModelIntroduction(Long modelId) {
//        Model model = modelRepository.findById(modelId)
//                .orElseThrow(() -> new NotFoundUserException());
//
//        return ModelIntroductionResponse.builder()
//                .modelImageKeywords(modelImageKeywordRepository.findAllById(modelId))
//                .modelRecentWorks(modelRecentWorkRepository.findAllById(modelId))
//                .modelRecentAdvertisements(modelRecentAdvertisementRepository.findAllById(modelId))
//                .build();
//    }
//
//    /**
//     * 모델소개 생성 서비스 로직
//     * @param modelId
//     * @return
//     */
//    @Override
//    public ModelIntroductionResponse createModelIntroduction(ModelIntroduceRequest request, Long modelId) {
//        Model model = modelRepository.findById(modelId)
//                .orElseThrow(() -> new NotFoundUserException());
//
//        ModelIntroduction modelIntroduction = modelIntroductionRepository.save(
//                ModelIntroduction.builder()
//                        .model(model)
//                        .build()
//        );
//
//        return ModelIntroductionResponse.builder()
//                .modelImageKeywords(request.modelImageKeywords())
//                .modelRecentWorks(request.modelRecentWorks())
//                .modelRecentAdvertisements(request.modelRecentAdvertisements())
//                .build();
//
//
//    }
//
//
//}
