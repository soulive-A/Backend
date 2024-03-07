package com.backend.soullive_a.controller;

import com.backend.soullive_a.dto.response.model.popularity.ModelPopularityResponse;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.service.ModelPopularityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "모델 화제성 API", description = "모델 화제성 API입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/model/popularity")
public class ModelPopularityController {

    private final ModelPopularityService modelPopularityService;

    @Operation(summary = "모델 화제성 API", description = "모델 화제성 정보를 조회하는 API입니다.")
    @GetMapping("")
    public BaseResponse<ModelPopularityResponse> getModelPopularity(
            @RequestParam String name
    ) {
        return BaseResponse.<ModelPopularityResponse>builder()
                .isSuccess(true)
                .code(200)
                .message(name+" 모델 화제성 조회에 성공했습니다.")
                .data(modelPopularityService.getModelPopularity(name))
                .build();
    }
}
