package com.backend.soullive_a.controller;

import com.backend.soullive_a.dto.request.ModelFitnessRequest;
import com.backend.soullive_a.dto.response.model.fitness.ModelFitnessResponse;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.service.impl.ModelFitnessServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "모델 적합도 API", description = "모델 적합도 이슈 API입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/model/fitness")
public class ModelFitnessController {
    private final ModelFitnessServiceImpl modelFitnessService;

    @Operation(summary = "모델 적합도 API", description = "모델 적합도 조회 API입니다.")
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
