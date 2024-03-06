package com.backend.soullive_a.service;

import com.backend.soullive_a.dto.response.model.popularity.ModelPopularityResponse;

public interface ModelPopularityService {

    ModelPopularityResponse getModelPopularity(String name);
}
