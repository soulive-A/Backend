package com.backend.soullive_a.controller;

import com.backend.soullive_a.dto.response.ModelIntroductionResponse;
import com.backend.soullive_a.service.ModelIntroductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/model/introduction")
public class ModelIntroductionController {

    private final ModelIntroductionService modelIntroductionService;

    /**
     * 모델소개 조회 api
     * @param modelId
     * @return
     */
    @GetMapping("/{modelId}")
    public ModelIntroductionResponse getModelInroduction(@PathVariable Long modelId) {
        return modelIntroductionService.getModelIntroduction(modelId);
    }
}
