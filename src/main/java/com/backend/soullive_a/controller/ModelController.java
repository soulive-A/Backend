package com.backend.soullive_a.controller;

import com.backend.soullive_a.dto.response.ModelRecommendResponse;
import com.backend.soullive_a.dto.response.ModelResponse;
import com.backend.soullive_a.dto.response.RecentModelResponse;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.service.ModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@Tag(name = "모델 API", description = "모델 조회,생성,최근 조회한 모델 API입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/model")
public class ModelController {
    private final ModelService modelService;

    /**
     * 모델 조회 api
     * @param modelName
     * @return
     */
    @Operation(summary = "모델 조회 API", description = "모델 기본 정보를 조회하는 API입니다.")
    @GetMapping("")
    public BaseResponse<ModelResponse> getModel(@RequestParam String modelName, @RequestParam Long productId) {
        return BaseResponse.<ModelResponse>builder()
                .isSuccess(true)
                .code(200)
                .message("모델 조회에 성공했습니다.")
                .data(modelService.getModel(modelName,productId))
                .build();

    }

    @Operation(summary = "최근 조회 모델 API", description = "최근 조회한 모델들을 조회하는 API입니다.")
    @GetMapping("/recent/{productId}")
    public BaseResponse<List<RecentModelResponse>> getRecentModel(@Parameter(name = "상품 id",description = "상품 기본키(필수)",
        required = true) @PathVariable Long productId){
        return BaseResponse.<List<RecentModelResponse>>builder()
            .isSuccess(true)
            .code(200)
            .message("최근 조회한 모델 조회 성공")
            .data(modelService.getRecentModel(productId))
            .build();
    }

    @Operation(summary = "모델 추천 API", description = "모델을 추천 받는 API이다.")
    @GetMapping("/recommendation")
    public BaseResponse<List<ModelRecommendResponse>> getRecommendModel(){
        return BaseResponse.<List<ModelRecommendResponse>>builder()
            .isSuccess(true)
            .code(200)
            .message("모델 추천 성공")
            .data(modelService.getRecommendModel())
            .build();
    }
}
