package com.backend.soullive_a.service;

import com.backend.soullive_a.dto.request.ModelRequest;
import com.backend.soullive_a.dto.response.ModelResponse;
import com.backend.soullive_a.dto.response.RecentModelResponse;
import java.util.List;

public interface ModelService {
    public ModelResponse getModel(String modelName, Long productId);


    public ModelResponse createModel(ModelRequest request);

    public List<RecentModelResponse> getRecentModel(Long productId);
}
