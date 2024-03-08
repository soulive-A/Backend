package com.backend.soullive_a.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "모델 추천 응답 model")
public record ModelRecommendResponse(
    @Schema(name = "imageUrl", example = "https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_profile.png", description = "모델 이미지 url입니다.")
    String imageUrl,
    @Schema(name = "name", example = "김희애", description = "모델 이름입니다.")
    String name,
    @Schema(name = "job", example = "배우", description = "모델 직업(구분자)입니다.")
    String job
) {

}
