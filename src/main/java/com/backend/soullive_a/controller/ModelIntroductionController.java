
package com.backend.soullive_a.controller;

import com.backend.soullive_a.dto.request.ModelIntroduceRequest;
import com.backend.soullive_a.dto.response.ModelIntroductionResponse;
import com.backend.soullive_a.dto.response.ModelResponse;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.service.ModelIntroductionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/model/introduction")
public class ModelIntroductionController {

    private final ModelIntroductionService modelIntroductionService;

    /**
     * 모델소개 조회 api
     * @param modelName
     * @return
     */
    @GetMapping("")
    public BaseResponse<ModelIntroductionResponse> getModelIntroduction(@RequestParam String modelName) {
        return BaseResponse.<ModelIntroductionResponse>builder()
                .isSuccess(true)
                .code(2006)
                .message("모델소개 정보 조회에 성공했습니다.")
                .data(modelIntroductionService.getModelIntroduction(modelName))
                .build();
    }




}

