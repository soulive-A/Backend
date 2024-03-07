package com.backend.soullive_a.dto.response.model.fitness;

import jakarta.persistence.Column;
import lombok.Builder;

import java.util.List;

@Builder

public record ModelFitnessResponse(
        String scoreUrl,
        String aiComment,
        List<String> modelImageKeywordList,
        List<String> brandImageKeywordList,
        List<String> productImageKeywordList


) {
}
