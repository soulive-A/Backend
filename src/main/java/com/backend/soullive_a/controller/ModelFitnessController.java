package com.backend.soullive_a.controller;

import com.backend.soullive_a.dto.request.ModelFitnessRequest;
import com.backend.soullive_a.dto.response.model.fitness.ModelFitnessResponse;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.service.impl.ModelFitnessServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/model/fitness")
public class ModelFitnessController {
    private final ModelFitnessServiceImpl modelFitnessService;

    @GetMapping("")
    public BaseResponse<ModelFitnessResponse> getModelFitness(
            @RequestParam String modelName,
            @RequestParam Long productId
    ) {
        return BaseResponse.<ModelFitnessResponse>builder()
                .code(200)
                .message("모델 적합도 조회에 성공했습니다.")
                .isSuccess(true)
                .data(modelFitnessService.getModelFitness(new ModelFitnessRequest(modelName, productId)))
                .build();
    }

}
