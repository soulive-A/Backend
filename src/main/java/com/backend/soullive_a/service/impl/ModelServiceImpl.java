package com.backend.soullive_a.service.impl;

import com.backend.soullive_a.dto.request.ModelRequest;
import com.backend.soullive_a.dto.response.ModelResponse;
import com.backend.soullive_a.entity.model.Model;
import com.backend.soullive_a.exception.custom.NotFoundUserException;
import com.backend.soullive_a.repository.ModelRepository;
import com.backend.soullive_a.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    @Override
    public ModelResponse getModel(Long modelId) {
         Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new NotFoundUserException());

        return ModelResponse.builder()
                .modelId(model.getId())
                .modelName(model.getModelName())
                .birth(model.getBirth())
                .job(model.getJob())
                .info(model.getInfo())
                .agency(model.getAgency())
                .aiRate(model.getAiRate())
                .build();
    }

    @Override
    public ModelResponse createModel(ModelRequest request) {
        // 중복 검사 로직 추가
         Model model = modelRepository.save(Model.builder()
                .modelName(request.modelName())
                .birth(request.birth())
                .job(request.job())
                .info(request.info())
                .agency(request.agency())
                .aiRate(request.aiRate())
                .build());

        return ModelResponse.builder()
                .modelId(model.getId())
                .modelName(model.getModelName())
                .birth(model.getBirth())
                .job(model.getJob())
                .info(model.getInfo())
                .agency(model.getAgency())
                .aiRate(model.getAiRate())
                .build();
    }

}
