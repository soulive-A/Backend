package com.backend.soullive_a.dto.request;

import com.backend.soullive_a.constant.AgeType;
import com.backend.soullive_a.constant.GenderType;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateProductRequest (
    @NotNull String company,
    String brand,
    @NotNull List<String> brandImage,
    @NotNull String product,
    @NotNull String characteristic,
    @NotNull List<String> productImage,
    @NotNull List<GenderType> gender,
    @NotNull List<AgeType> age,
    @NotNull List<String> range
){
}
