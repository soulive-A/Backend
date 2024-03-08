package com.backend.soullive_a.controller;

import com.backend.soullive_a.dto.response.model.issue.ModelIssueResponse;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.service.ModelIssueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "모델 부정 이슈 API", description = "모델 부정 이슈 API입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/model/issue")
public class ModelIssueController {
    private final ModelIssueService modelIssueService;

    @Operation(summary = "모델 부정 이슈 조회 API", description = "특정 모델 부정 이슈 조회 API입니다.")
    @GetMapping()
    public BaseResponse<ModelIssueResponse> getIssue(@RequestParam String modelName) {
        return BaseResponse.<ModelIssueResponse>builder()
                .code(200)
                .message("부정이슈 조회에 성공했습니다.")
                .isSuccess(true)
                .data(modelIssueService.getIssue(modelName))
                .build();
    }
}
