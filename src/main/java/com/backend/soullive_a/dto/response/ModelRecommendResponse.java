package com.backend.soullive_a.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "모델 추천 응답 model")
public record ModelRecommendResponse(
    @Schema(name = "모델 이미지 url", example = "https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_profile.png")
    String imageUrl,
    @Schema(name = "모델 이름", example = "김희애")
    String name,
    @Schema(name = "모델 직업 구분", example = "텔런트/영화배우")
    String job
) {

}
