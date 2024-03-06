
package com.backend.soullive_a.controller;


import com.backend.soullive_a.dto.response.ModelIntroductionResponse;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.service.ModelIntroductionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@Tag(name = "모델 소개 API", description = "모델 소개 API입니다.")
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
    @Operation(summary = "모델 소개 API", description = "모델 소개 정보를 조회하는 API입니다.")
    @GetMapping("")
    public BaseResponse<ModelIntroductionResponse> getModelIntroduction(@RequestParam String modelName) {
        return BaseResponse.<ModelIntroductionResponse>builder()
                .isSuccess(true)
                .code(2006)
                .message("모델소개 정보 조회에 성공했습니다.")
                .data(modelIntroductionService.getModelIntroduction(modelName))
                .build();
    }


//    @PostMapping("/{modelId}")
//    public BaseResponse<ModelIntroductionResponse> createModelIntroduction(
//            @PathVariable Long modelId,
//            @RequestBody @Valid ModelIntroduceRequest request) {
//        return BaseResponse.<ModelIntroductionResponse>builder()
//                .isSuccess(true)
//                .code(2006)
//                .message("모델소개 정보 생성에 성공했습니다.")
//                .data(modelIntroductionService.createModelIntroduction(request, modelId))
//                .build();
//    }

}

