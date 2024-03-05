package com.backend.soullive_a.dto.request;

import com.backend.soullive_a.constant.AgeType;
import com.backend.soullive_a.constant.GenderType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateProductRequest(
        @NotNull @Schema(example = "LG 전자") String company,
        @Schema(example = "LG 시그니처") String brand,
        @NotNull @Schema(example = "[\n\"프리미엄\", \"프로페셔널\"\n]") List<String> brandImage,
        @NotNull @Schema(example = "LG 시그니처 세탁건조기") String product,
        @NotNull @Schema(example = "올인원 세탁 방식") String characteristic,
        @NotNull @Schema(example = "[\n\"세련됨\", \"편리함\", \"혁신적인\"\n]") List<String> productImage,
        @NotNull @Schema(example = "[\n\"MALE\", \"FEMALE\"\n]") List<GenderType> gender,
        @NotNull @Schema(example = "[\n\"TEN\",\"TWENTY\",\"THIRTY\", \"FORTY\", \"FIFTY\", \"SIXTY\"\n]") List<AgeType> age,
        @NotNull @Schema(example = "[\n\"고소득층\", \"1인가구\", \"주부\"\n]") List<String> range
) {
}
