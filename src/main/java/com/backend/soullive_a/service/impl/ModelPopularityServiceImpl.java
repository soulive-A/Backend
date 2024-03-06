package com.backend.soullive_a.service.impl;

import com.backend.soullive_a.dto.response.model.popularity.ModelPopularityResponse;
import com.backend.soullive_a.entity.model.popularity.ModelPopularAge;
import com.backend.soullive_a.entity.model.popularity.ModelPopularGender;
import com.backend.soullive_a.entity.model.popularity.ModelPopularity;
import com.backend.soullive_a.entity.model.popularity.ModelScheduledWork;
import com.backend.soullive_a.repository.model.popularity.ModelPopularAgeRepository;
import com.backend.soullive_a.repository.model.popularity.ModelPopularGenderRepository;
import com.backend.soullive_a.repository.model.popularity.ModelPopularityRepository;
import com.backend.soullive_a.repository.model.popularity.ModelScheduledWorkRepository;
import com.backend.soullive_a.service.ModelPopularityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelPopularityServiceImpl implements ModelPopularityService {

    private final ModelPopularityRepository modelPopularityRepository;
    private final ModelPopularAgeRepository modelPopularAgeRepository;
    private final ModelPopularGenderRepository modelPopularGenderRepository;
    private final ModelScheduledWorkRepository modelScheduledWorkRepository;

    @Override
    @Transactional(readOnly = true)
    public ModelPopularityResponse getModelPopularity(String name) {
        ModelPopularity modelPopularity = modelPopularityRepository.findByModelModelName(name);
        List<ModelPopularGender> modelPopularGenders = modelPopularGenderRepository.findAllByModelPopularityModelModelName(name);
        List<ModelPopularAge> modelPopularAges = modelPopularAgeRepository.findAllByModelPopularityModelModelName(name);
        List<ModelScheduledWork> modelScheduledWorks = modelScheduledWorkRepository.findAllByModelPopularityModelModelName(name);
        return ModelPopularityResponse.fromModel(modelPopularity, modelPopularGenders, modelPopularAges, modelScheduledWorks);
    }
}