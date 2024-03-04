package com.backend.soullive_a.controller;

import com.backend.soullive_a.dto.request.ModelRequest;
import com.backend.soullive_a.dto.response.ModelResponse;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.service.ModelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @GetMapping("/model")
    public BaseResponse<ModelResponse> getModel(@RequestBody @Valid ModelRequest request) {
        return BaseResponse.<ModelResponse>builder()
                .isSuccess(true)
                .code(200)
                .message("모델 조회에 성공했습니다.")
                .data(modelService.getModel(request))
                .build();

    }
}
