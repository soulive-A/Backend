package com.backend.soullive_a.controller;

import com.backend.soullive_a.dto.response.model.popularity.ModelPopularityResponse;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.service.ModelPopularityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/model/popularity")
public class ModelPopularityController {

    private final ModelPopularityService modelPopularityService;

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
