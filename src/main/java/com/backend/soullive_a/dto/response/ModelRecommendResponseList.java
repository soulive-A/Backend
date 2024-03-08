package com.backend.soullive_a.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(name = "모델 추천 응답 리스트 세분화 model")
public record ModelRecommendResponseList(
    @Schema(name = "actors", description = "모델 추천에서 배우 리스트")
    List<ModelRecommendResponse> actors,
    @Schema(name = "singers", description = "모델 추천에서 가수 리스트")
    List<ModelRecommendResponse> singers,
    @Schema(name = "youtuber", description = "모델 추천에서 유튜버 리스트")
    List<ModelRecommendResponse> youtuber
) {

}
