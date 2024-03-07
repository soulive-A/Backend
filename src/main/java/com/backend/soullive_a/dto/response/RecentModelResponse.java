package com.backend.soullive_a.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "최근 조회한 모델 model 객체")
public record RecentModelResponse(
    @Schema(name = "모델 id(기본키)")
    Long modelId,
    @Schema(name = "모델 이미지 url")
    String imageUrl,
    @Schema(name = "모델 이름")
    String modelName,
    @Schema(name = "ai 추천 점수")
    Float aiRate
) {

}
