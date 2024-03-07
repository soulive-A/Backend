package com.backend.soullive_a.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "최근 조회한 모델 model 객체")
public record RecentModelResponse(
    @Schema(name = "모델 id(기본키)", example = "1")
    Long modelId,
    @Schema(name = "모델 이미지 url", example = "https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_profile.png")
    String imageUrl,
    @Schema(name = "모델 이름", example = "한지민")
    String modelName,
    @Schema(name = "ai 추천 점수", example = "3.0")
    Float aiRate
) {

}
