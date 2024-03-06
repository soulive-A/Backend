package com.backend.soullive_a.dto.response.model.popularity;

import com.backend.soullive_a.entity.model.popularity.ModelPopularAge;
import com.backend.soullive_a.entity.model.popularity.ModelPopularGender;
import com.backend.soullive_a.entity.model.popularity.ModelPopularity;
import com.backend.soullive_a.entity.model.popularity.ModelScheduledWork;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record ModelPopularityResponse(
        Long modelPopularityId,
        Long modelId,
        String scoreUrl,
        String aiComment,
        List<ModelPopularGenderResponse> genders,
        List<ModelPopularAgeResponse> ages,
        String snsUrl,
        String searchUrl,
        String brandScoreUrl,
        List<ModelScheduledWorkResponse> modelScheduledWorks
) {
    public static ModelPopularityResponse fromModel(
            ModelPopularity modelPopularity,
            List<ModelPopularGender> modelPopularGender,
            List<ModelPopularAge> modelPopularAge,
            List<ModelScheduledWork> modelScheduledWork
            ) {
        List<ModelPopularGenderResponse> modelPopularGenders = modelPopularGender.stream()
                .map(gender -> new ModelPopularGenderResponse(gender.getId(), gender.getGender()))
                .collect(Collectors.toList());

        List<ModelPopularAgeResponse> modelPopularAges = modelPopularAge.stream()
                .map(age -> new ModelPopularAgeResponse(age.getId(), age.getAge()))
                .collect(Collectors.toList());

        List<ModelScheduledWorkResponse> modelScheduledWorks = modelScheduledWork.stream()
                .map(work -> new ModelScheduledWorkResponse(
                        work.getId(),
                        work.getImageUrl(),
                        work.getYear(),
                        work.getCategory(),
                        work.getTitle(),
                        work.getIsMainActor(),
                        work.getGenre()))
                .collect(Collectors.toList());

        return ModelPopularityResponse.builder()
                .modelId(modelPopularity.getModel().getId())
                .modelPopularityId(modelPopularity.getId())
                .scoreUrl(modelPopularity.getScoreUrl())
                .aiComment(modelPopularity.getAiComment())
                .genders(modelPopularGenders)
                .ages(modelPopularAges)
                .snsUrl(modelPopularity.getSnsUrl())
                .searchUrl(modelPopularity.getSearchUrl())
                .brandScoreUrl(modelPopularity.getBrandScoreUrl())
                .modelScheduledWorks(modelScheduledWorks)
                .build();
    }
}