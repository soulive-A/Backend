package com.backend.soullive_a.controller;

import com.backend.soullive_a.dto.request.ModelRequest;
import com.backend.soullive_a.dto.response.ModelResponse;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.service.ModelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/model")
public class ModelController {
    private final ModelService modelService;

    /**
     * 모델 조회 api
     * @param modelId
     * @return
     */
    @GetMapping("/{modelId}")
    public BaseResponse<ModelResponse> getModel(@PathVariable Long modelId) {
        return BaseResponse.<ModelResponse>builder()
                .isSuccess(true)
                .code(200)
                .message("모델 조회에 성공했습니다.")
                .data(modelService.getModel(modelId))
                .build();

    }

    /**
     * 모델 등록 api
     * @param request
     * @return
     */
    @PostMapping("")
    public BaseResponse<ModelResponse> createModel(@RequestBody @Valid ModelRequest request) {
        System.out.println("@");
        return BaseResponse.<ModelResponse>builder()
                .isSuccess(true)
                .code(200)
                .message("모델 생성에 성공했습니다.")
                .data(modelService.createModel(request))
                .build();

    }
}
