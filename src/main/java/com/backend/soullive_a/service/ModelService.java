package com.backend.soullive_a.service;

import com.backend.soullive_a.dto.request.ModelRequest;
import com.backend.soullive_a.dto.response.ModelResponse;

public interface ModelService {
    public ModelResponse getModel(ModelRequest request);
}
