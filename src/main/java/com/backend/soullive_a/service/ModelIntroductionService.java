
package com.backend.soullive_a.service;

import com.backend.soullive_a.dto.request.ModelIntroduceRequest;
import com.backend.soullive_a.dto.response.ModelIntroductionResponse;

import java.util.List;

public interface ModelIntroductionService {
    public ModelIntroductionResponse getModelIntroduction(String modelName);


}

