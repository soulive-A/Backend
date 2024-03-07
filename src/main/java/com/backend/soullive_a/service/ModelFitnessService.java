package com.backend.soullive_a.service;

import com.backend.soullive_a.dto.request.ModelFitnessRequest;
import com.backend.soullive_a.dto.response.model.fitness.ModelFitnessResponse;

public interface ModelFitnessService {
    public ModelFitnessResponse getModelFitness(ModelFitnessRequest request);
}
