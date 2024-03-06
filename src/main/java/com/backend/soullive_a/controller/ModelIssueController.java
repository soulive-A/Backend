package com.backend.soullive_a.controller;

import com.backend.soullive_a.dto.response.model.issue.ModelIssueResponse;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.service.ModelIssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/model/issue")
public class ModelIssueController {
    private final ModelIssueService modelIssueService;
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
