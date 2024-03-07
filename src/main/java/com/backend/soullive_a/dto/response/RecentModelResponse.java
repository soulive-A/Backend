package com.backend.soullive_a.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "최근 조회한 모델 model 객체")
public record RecentModelResponse(
    @Schema(name = "modelId", example = "1", description = "모델 기본키")
    Long modelId,
    @Schema(name = "imageUrl", example = "https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_profile.png", description = "모델 이미지 url입니다.")
    String imageUrl,
    @Schema(name = "modelName", example = "한지민", description = "모델 이름입니다.")
    String modelName,
    @Schema(name = "aiRate", example = "3.0", description = "ai 추천 점수입니다.")
    Float aiRate
) {

}
